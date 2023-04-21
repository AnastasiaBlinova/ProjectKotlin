package com.example.list

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class TaskItemRepository(private val taskItemDao: TaskItemDao ) {
    val allTaskItems: Flow<List<TaskItemBD>> = taskItemDao.allTaskItems()

    @WorkerThread
    suspend fun insertTaskItem(taskItemBD: TaskItemBD){
        taskItemDao.insertTaskItem(taskItemBD)
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