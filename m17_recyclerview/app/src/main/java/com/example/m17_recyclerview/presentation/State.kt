package com.example.m17_recyclerview.presentation

import com.example.m17_recyclerview.entity.UsefulPhotoSputnik

sealed class State{
    object Start : State()
    object Loading : State()
    object Result : State()
    data class Error(
        val stringError: String?
    ) : State()


}