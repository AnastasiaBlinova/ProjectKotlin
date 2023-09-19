package com.example.m18_permissions

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        PhotosOfSights::class
    ],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase: RoomDatabase(){
    abstract fun photoDao(): Dao
}