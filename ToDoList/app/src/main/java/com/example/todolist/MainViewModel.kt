package com.example.todolist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.sql.Timestamp

class MainViewModel (/*private val dealDao: DealDao*/) : ViewModel() {
    // TODO: Implement the ViewModel
    //var name = MutableLiveData<String>()
   // var desc = MutableLiveData<String>()
    var taskItemBD = MutableLiveData<MutableList<TaskItemBD>?>()
    init {
        taskItemBD.value = mutableListOf()
    }
    fun addTaskItem(newTask: TaskItemBD){
        val list = taskItemBD.value
        list!!.add(newTask)
        taskItemBD.postValue(list)
    }
    fun updateTaskItem(id:Int, name: String, description: String, dateStart: Timestamp){
        val list = taskItemBD.value
        val task = list!!.find { it.id == id }
        task?.name = name
        task?.description = description
        task?.dateStart = dateStart
        taskItemBD.postValue(list)
    }

    fun setCompleted(taskItem: TaskItemBD){
        val list = taskItemBD.value
        val task = list!!.find { it.id == taskItem.id }!!
        //if (task.complitedDate == null)
        //    task.complitedDate = LocalDate.now()
        taskItemBD.postValue(list)
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