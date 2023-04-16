package com.example.list

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskItemDao {
    @Query("SELECT * FROM task_item_table ORDER BY id ASC")
    fun allTaskItems(): Flow<List<TaskItemBD>>

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun insertTaskItem(taskItemBD: TaskItemBD)

    @Update
    suspend fun updateTaskItem(taskItemBD: TaskItemBD)

    @Delete//("delete from task_item_table")
    suspend fun deleteTaskItem(taskItemBD: TaskItemBD)
}