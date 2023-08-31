package com.example.m17_recyclerview

sealed class State {      // в MainViewModel будет храниться состояние и которое можно будет менять
    object Start : State()
    object Loading : State()
    object Result : State()
    data class Error(
        val searchError: String?
    ) :State()  //сделаем его дата класс чтобы можно было передавать ошибку на отображение

}
