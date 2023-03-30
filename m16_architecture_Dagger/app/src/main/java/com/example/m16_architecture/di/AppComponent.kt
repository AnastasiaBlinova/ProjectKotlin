package com.example.m16_architecture.di

import com.example.m16_architecture.presentation.MainFragment
import com.example.m16_architecture.presentation.MainViewModelFactory
import dagger.Component

@Component
interface AppComponent {
    //fun mainViewModelFactory(): MainViewModelFactory
    fun injectMainFragment(fragment: MainFragment) // инжектит все нужные зависимости в мэйн фрагмент

}