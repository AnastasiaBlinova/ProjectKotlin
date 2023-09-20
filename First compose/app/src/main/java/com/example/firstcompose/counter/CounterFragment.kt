package com.example.firstcompose.counter

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CounterFragment: Fragment() {
    private val viewModel by viewModels<CounterViewModel>{
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return CounterViewModel() as? T ?: throw IllegalStateException()
            }
        }
    }
    //чтобы подключить ui отображение компонентов нужно переопределить метод
    override fun onCreateView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = ComposeView(requireContext())
        view.setContent {
            // перед тем как перейти к верстке разберем нашу вью модель на стандартные компоненты
            // для подключения к джет пак компоус. Первым делом представим MutableStateFlow из
            // стандартной библиотеки котлин как State из библиотеки джет пк компоус
            val counterState = viewModel.counter.collectAsState()
            val stepState = viewModel.step.collectAsState()

            View(
                counter = counterState.value,
                step = stepState.value,
                counterSetter = {newCount -> viewModel.counter.value = newCount},
                stepSetter = {newStep -> viewModel.step.value = newStep}
            )
        }
        return view
    }
}
@Composable
fun View(
    //объявим значения коорые будут влиять на наше отображение
    counter: Int,
    step: Int,
//лямбда, которая принимает в качестве аргумента переменную типа Int и возвращает Unit
    counterSetter: (Int) -> Unit,
    stepSetter: (Int) -> Unit,
){
   // Text(text = "hello")
    Column {
        Row {
            Button(onClick = {counterSetter(counter-step)}) {
                Text(text = "-")
            }
            TextField(
                value = counter.toString(),
                onValueChange = {newText -> newText.toIntOrNull()?.let{counterSetter(it)}} )
            Button(onClick = {counterSetter(counter+step)}) {
                Text(text = "+")
            }
        }
        Row {
            Button(onClick = {stepSetter(step-1)}) {
                Text(text = "-")
            }
            TextField(
                value = step.toString(),
                onValueChange = {newText -> newText.toIntOrNull()?.let{stepSetter(it)}} )
            Button(onClick = {stepSetter(step+1)}) {
                Text(text = "+")
            }
        }
    }
}

//метод для отображения view
@Preview (showBackground = true)
@Composable
fun previewMyText(){
    View(
        counter = 0,
        step = 0,
        counterSetter = {print("new count is $it")},
        stepSetter = {print("new step is $it")}
    )
}