package com.example.list

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

class TaskViewModel(private val repository: TaskItemRepository): ViewModel () {
    var taskItems: LiveData<List<TaskItemBD>> = repository.allTaskItems.asLiveData()

    //добавить элемент задачи
    fun addTaskItem(newTask:TaskItemBD) = viewModelScope.launch {
        repository.insertTaskItem(newTask)
    }

    fun updateTaskItem(taskItem: TaskItemBD) = viewModelScope.launch {
        repository.updateTaskItem(taskItem)
    }

    fun setCompleted(taskItem: TaskItemBD) = viewModelScope.launch {
        if(!taskItem.isCompleted()) {
            taskItem.completedDateString = TaskItemBD.dateFormatter.format(LocalDate.now())
        }
        repository.updateTaskItem(taskItem)
        delay(5000)
        repository.deleteTaskItem(taskItem)
        repository.updateTaskItem(taskItem)
    }
}

