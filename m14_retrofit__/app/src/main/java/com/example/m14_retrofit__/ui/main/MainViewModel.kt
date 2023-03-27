package com.example.m14_retrofit__.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = Repository()

    private val _state = MutableStateFlow<State>(State.Result)
    val state = _state.asStateFlow()

    private val _personModel = Channel<PersonModel> ()
    val personModel = _personModel.receiveAsFlow()

    private val _error = Channel<String>()
    val error = _error.receiveAsFlow()

    fun reloadPerson() = viewModelScope.launch {
        _state.value = State.Loading
        delay(500)
        try {
            _personModel.send(repository.getData())
        }catch (e:Exception){
            _state.value = State.Error("Error: ${e.message}")
        }
        _state.value = State.Result
    }

}