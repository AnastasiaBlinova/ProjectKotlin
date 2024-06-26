package com.example.m18_permissions

import android.app.Application
import androidx.room.Room

class App : Application() {

    lateinit var db: AppDatabase

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(       //databaseBuilder передаем :
            applicationContext,                 // контекст
            AppDatabase::class.java,             // класс датабэйс
            "bd"
        )
            .build()
    }
}