package lesson_14_7

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlin.random.Random

fun main() {
    runBlocking {
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


    }
}

object GeneratorShared {
    private val scope = CoroutineScope(Job() + Dispatchers.Default)
    private val _sharedFlow = MutableSharedFlow<Int>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    init    {
        scope.launch {
            repeat(10){
                _sharedFlow.emit(Random.nextInt(90,101))
                delay(500)
            }

        }
    }
}