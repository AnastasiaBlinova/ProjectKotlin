package com.example.m18_permissions

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@androidx.room.Dao
interface Dao {
    @Transaction
    @Query("SELECT * " +
            "FROM sights")
    fun getAll(): Flow<List<PhotosOfSights>>   // для получения всего списка;  Flow позволяет получать данные об обновлениях

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(photosOfSights: PhotosOfSights)       // для получения ставки

    @Update
    suspend fun update(photosOfSights: PhotosOfSights)       // для обновления
}