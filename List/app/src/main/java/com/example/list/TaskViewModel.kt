package com.example.list

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

class TaskViewModel: ViewModel () {
    var taskItems = MutableLiveData<MutableList<TaskItemBD>>()
    //var name = MutableLiveData<String>()          1
    //var desc = MutableLiveData<String>()          1
    init {
        taskItems.value = mutableListOf()
    }

    //добавить элемент задачи
    fun addTaskItem(newTask:TaskItemBD){
        val list = taskItems.value
        list!!.add(newTask)
        taskItems.postValue(list)
    }

    //обновить элемент задачи
    fun updateTaskItem(id: UUID, name: String, desc: String, dueTime: LocalTime? ){
        val list = taskItems.value
        val task = list!!.find { it.id == id}!!
        task.name = name
        task.desc = desc
        task.dueTime = dueTime
        taskItems.postValue(list)
    }

    //добавить задачу
    @RequiresApi(Build.VERSION_CODES.O)
    fun setCompleted(taskItem:TaskItemBD){
        val list = taskItems.value
        val task = list!!.find { it.id == taskItem.id}!!
        if(task.completedDate == null)
            task.completedDate = LocalDate.now()
        taskItems.postValue(list)
    }
}