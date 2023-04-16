package com.example.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TaskItemModelFactory(private val repository: TaskItemRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TaskViewModel::class.java))
            return TaskViewModel(repository) as T

        throw IllegalArgumentException("Unknown Class for view Model")
    }
}