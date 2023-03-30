package com.example.m16_architecture.presentation

import com.example.m16_architecture.domain.GetUsefulActivityUseCase
import com.example.m16_architecture.entity.UsefulActivity

sealed class State{
    object Start : State()
    object Loading : State()
    class Result(useCaseResult: UsefulActivity?) : State()
    data class Error(
        val stringError: String?
    ) : State()


}
