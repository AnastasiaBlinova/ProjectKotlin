package org.example.lesson_14_5


import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main (){  // создадим два flow  с числами и со строками
    val nums = (1..3).asFlow().onEach { delay(1000) }
    val strs = flowOf("one", "two", "three").onEach { delay(2000) }
    runBlocking {
        launch {
            nums
//                .zip(strs) {number, string -> "$number - $string"}
                .combine(strs) {number, string -> Result(number, string)/*"$number - $string"*/}
                .collect { println(it) }
        }
    }
}
class Result(val number : Int , val str: String)