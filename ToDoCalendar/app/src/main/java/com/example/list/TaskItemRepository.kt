package com.example.list

import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.flow.Flow

class TaskItemRepository(private val taskItemDao: TaskItemDao ) {
    val allTaskItems: Flow<List<TaskItemBD>> = taskItemDao.allTaskItems()
    //val taskItemsDate = MutableLiveData<List<TaskItemBD>>

    @WorkerThread
    suspend fun insertTaskItem(taskItemBD: TaskItemBD){
        taskItemDao.insertTaskItem(taskItemBD)
    }

    @WorkerThread
    suspend fun findByDate(date: String){
        taskItemDao.findByDate(date)
    }

    @WorkerThread
    suspend fun updateTaskItem(taskItemBD: TaskItemBD){
        taskItemDao.updateTaskItem(taskItemBD)
    }

    @WorkerThread
    suspend fun deleteTaskItem(taskItemBD: TaskItemBD){
        taskItemDao.deleteTaskItem(taskItemBD)
    }
}