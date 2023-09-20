package com.example.firstcompose.counter

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class CounterViewModel: ViewModel() {
    val counter = MutableStateFlow(0) // счетчик котрый мы можем изменять, путем изменения состояния MutableStateFlow
    val step = MutableStateFlow(0) // величина на которую мы можем изменять значение counter
}