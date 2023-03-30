package com.example.m16_architecture.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class MainViewModelFactory @Inject constructor (
    val mainViewModel: MainViewModel
): ViewModelProvider.Factory { //++ mainViewModel: MainViewModel в конструктор

    override fun <T : ViewModel> create(modelClass: Class<T>): T {     //реализуем метод create
        if( modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return mainViewModel as T
        }
        //если будем неправильно использовать фабрику, то будем выкидявать ошибку
        throw  IllegalArgumentException("Unknown class name")  // далее добавляем эту фабрику в
        // делигат т.е в класс MainFragment в переменную viewModel
    }
}