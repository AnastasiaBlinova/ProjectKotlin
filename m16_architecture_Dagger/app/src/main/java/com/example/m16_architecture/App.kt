package com.example.m16_architecture

import android.app.Application
import com.example.m16_architecture.di.AppComponent
import com.example.m16_architecture.di.DaggerAppComponent

/*@HiltAndroidApp
class App: Application()*/

class App: Application() {
    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        //Dagger
        component = DaggerAppComponent.builder().build()
    }
}