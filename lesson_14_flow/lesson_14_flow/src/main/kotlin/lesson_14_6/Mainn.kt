package lesson_14_6

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main(){
    val flow = flow {
        //    try {
        repeat(5){
            delay (1000)
            val number = Random.nextInt(1, 101)
            if (Random.nextBoolean())
                error("Error occurred for $number")
            emit(number)
        }
        //    } catch (t: Throwable){
        //        println(t.message)
        //    }
    }
    runBlocking {
        flow
            //         .catch { println("emit error $it") }//обрабатывает ошибки до него
            .catch { throw it }//опускаем дальше ошибку
            .onEach { println(it) }
            .map {if (it > 50) error("too much $it")}
            .catch { println("mapping error $it") }
            .launchIn(this)
    }
}