package com.example.myapplication

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        Words::class
    ],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase: RoomDatabase(){
    abstract fun wordDao(): WordDao
}