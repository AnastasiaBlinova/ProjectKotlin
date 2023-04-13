package com.example.todolist

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

/*@Dao
interface DealDao {
    @Transaction
    @Query("SELECT * FROM list")
    fun getAllDeeds(): Flow<List<Deeds>>  // для получения всего списка;  Flow позволяет получать данные об обновлениях

    @Query("delete from list ")
    suspend fun deleteAll()      // для удаления одного  (words: Words)

    @Query("SELECT * FROM list WHERE date LIKE:date")
    fun getDeeds(date: String): Flow<List<Deeds>>
}*/