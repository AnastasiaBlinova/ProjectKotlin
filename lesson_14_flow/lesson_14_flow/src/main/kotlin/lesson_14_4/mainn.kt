package lesson_14_4

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.random.Random

fun main() {                                     // чтобы суспенд использовать
    runBlocking {
        launch {
            distinctFliw
                .distinctUntilChanged()    // фильтрация одинаковых подряд значений в потоке
                .collect{// use для сбора значений
                    println(it)
                }
        }
    }

}
val itermediateFlow = (0..10)
    .asFlow()
    //   .map { it * it }      то же что и Flow<Int>.square()
    .square()
    .filter { it % 2 == 0 }
    .take(3)

fun Flow<Int>.square() : Flow<Int> = transform {
        value ->
    return@transform emit(value * value)
}
//создадим флоу для имитации работы датчика

val distinctFliw = flow {
    repeat(10){
        emit(Random.nextBoolean())
        delay(500)
    }

}
