package com.example.m16_architecture.presentation

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m16_architecture.data.UsefulActivityDto
import com.example.m16_architecture.domain.GetUsefulActivityUseCase
import com.example.m16_architecture.entity.UsefulActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor (
    private val getUsefulActivityUseCase: GetUsefulActivityUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<State>(State.Start)   // в этом параметре хранится состояние, и обязательно значение по умолчанию
    val state = _state.asStateFlow()                            // чтобы следить за состоянием без возможности изменить

    private val _activityModel = Channel<UsefulActivity> ()
    val activityModel = _activityModel.receiveAsFlow()

    private  val _error =  Channel<String> ()
    val error = _error.receiveAsFlow()

    fun reloadUsefulActivity(){
        Log.d(ContentValues.TAG, "reloadUsefulActivity: Старт ")
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = State.Loading
               //++delay(3000)
            //try {
           //     _activityModel.send(getUsefulActivityUseCase.execute() as UsefulActivityDto)
           // }catch (e:Exception){
           //     _state.value = State.Error("Error: ${e.message}")
           // }
           // _state.value = State.Result
            val useCaseResult = getUsefulActivityUseCase.execute()
            useCaseResult?.let {
                _state.value = State.Result(useCaseResult)
                _activityModel.send(useCaseResult)
            }
            if (useCaseResult == null)
               _state.value = State.Error("Server error! You can do it later....")
        }
        Log.d(ContentValues.TAG, "reloadUsefulActivity: Финиш ")
    }
}