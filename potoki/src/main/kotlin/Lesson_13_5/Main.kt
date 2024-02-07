package Lesson_13_5

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking{
    launch {
        delay(2000)
        print("world")
    }
    launch {
        for (i in 1..500){
            delay(10)
            if (i % 130 == 0)
                println(".$i")
            else
                print(".$i")
        }
    }

    println("Hello")
}