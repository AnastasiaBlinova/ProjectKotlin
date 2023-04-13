package com.example.todolist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.sql.Timestamp
import java.time.LocalDate

class MainViewModel (/*private val dealDao: DealDao*/) : ViewModel() {
    // TODO: Implement the ViewModel
    //var name = MutableLiveData<String>()
   // var desc = MutableLiveData<String>()
    var deeds = MutableLiveData<MutableList<Deeds>?>()
    init {
        deeds.value = mutableListOf()
    }
    fun addTaskItem(newTask: Deeds){
        val list = deeds.value
        list!!.add(newTask)
        deeds.postValue(list)
    }
    fun updateTaskItem(id:Int, name: String, description: String, dateStart: Timestamp){
        val list = deeds.value
        val task = list!!.find { it.id == id }
        task?.name = name
        task?.description = description
        task?.dateStart = dateStart
        deeds.postValue(list)
    }

    fun setCompleted(taskItem: Deeds){
        val list = deeds.value
        val task = list!!.find { it.id == taskItem.id }!!
        //if (task.complitedDate == null)
        //    task.complitedDate = LocalDate.now()
        deeds.postValue(list)
    }
/*
    private var _stateButton = MutableStateFlow(false)    // в этом параметре хранится состояние для кнопки
    val stateButton = _stateButton.asStateFlow()

    fun setStateButton(value: Boolean){         //передаем значение состояния кнопки
        _stateButton.value = value
    }

    fun read (date: String){
        viewModelScope.launch {
            val findDate = dealDao.
        }
    }*/
    //val allDeals = this.dealDao.getDeeds()*/
}