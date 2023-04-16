package com.example.list

interface TaskItemClickListener {
    fun editTaskItem(taskItem: TaskItemBD)
    fun completeTaskItem(taskItem: TaskItemBD)
}