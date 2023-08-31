package com.example.m17_recyclerview

import android.app.Application
import com.example.m17_recyclerview.di.AppComponent


class App: Application() {
    companion object {
        lateinit var component: AppComponent
    }

//    override fun onCreate() {
//        super.onCreate()
//        //Dagger
//        component = DaggerAppComponent.builder().build()
//    }
}
