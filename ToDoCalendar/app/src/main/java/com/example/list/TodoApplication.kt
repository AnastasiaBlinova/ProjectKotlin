package com.example.list

import android.app.Application

class TodoApplication: Application() {
    private  val database by lazy {TaskItemDatebase.getDatabase(this)}
    val repository by lazy { TaskItemRepository(database.taskItemDao())}
}