package com.example.m17_recyclerview.di

import com.example.m17_recyclerview.presentation.FirstFragment
import dagger.Component

@Component
interface AppComponent {
    fun injectMainFragment(fragment: FirstFragment) // инжектит все нужные зависимости в ферст фрагмент
}