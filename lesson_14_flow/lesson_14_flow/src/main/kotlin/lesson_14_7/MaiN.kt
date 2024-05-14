package lesson_14_7

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.takeWhile
import kotlin.random.Random

fun main() {
    val numbers = Numbers()
    runBlocking {
        launch {
            delay(2000)
            withTimeout(10000){  // withTimeout  отписка таймаута через время
                numbers.sharedFlow.collect {
                    println(it)
                }
            }

        }
                                                          // добавим еще обного подписчика
        launch {
            delay(4000)
            withTimeout(8000) {
                numbers.sharedFlow.collect {
                    println("second collector - $it")
                }
            }
        }
//        launch {
//            var counter = 0                             //  1 вариант Для отмены
//            GeneratorShared.sharedFlow.collect {
//                println(it)
//                counter ++
//                if (counter >= 5)
//                    cancel()
//            }
//        }

//        val job = launch {                            //  2   вариант Для отмены
//            GeneratorShared.sharedFlow.collect {
//                println(it)
//            }
//        }
//        delay(5000)
//        job.cancel()

//        launch {
//            GeneratorShared.sharedFlow
//                .takeWhile { it != 100 }
//                .collect { println(it)                 }
//        }
    }
}

class Numbers {                                                // для демонстрации горячего источника
    private val scope = CoroutineScope(Job() + Dispatchers.Default)
    private val _sharedFlow = MutableSharedFlow<Int>( replay = 2)       //replay ко-во элементов, который получит новый подписчик sharedflow из буфера
    val sharedFlow = _sharedFlow.asSharedFlow()

    init    {
        scope.launch {
            for (i in 0..10){
                _sharedFlow.emit(i)
                delay(500)
            }
        }
    }
}

object GeneratorShared {                                         // для демонстрации холодного источника
    private val scope = CoroutineScope(Job() + Dispatchers.Default)
    private val _sharedFlow = MutableSharedFlow<Int>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    init    {
        scope.launch {
            repeat(10){
                _sharedFlow.emit(Random.nextInt(90,101))
                delay(500)
            }
            _sharedFlow.emit(100)
   //         scope.cancel()                               для варианта отмены
        }
    }
}
