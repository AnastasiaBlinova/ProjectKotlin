package Lesson_13_6

import Lesson_13_4.Callback
import Lesson_13_4.magicNumber
import kotlinx.coroutines.*
import java.math.BigInteger
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

fun main(){
//    val scope = CoroutineScope(Dispatchers.Default)
//    scope.launch {
    runBlocking {
        launch {
            println("Start runBlocking...")
            // doSomeWork()
            suspendMagicNumber()
            println("Finish runBlocking...")
        }
    }
}

suspend fun doSomeWork(){
    println("Start work...")
    delay(3000)
    println("Finish work...")
}

suspend fun suspendMagicNumber(){
    suspendCoroutine<BigInteger> {//если нет возвращаемого типа пишем unit
         continuation ->
        magicNumber(object : Callback{
            override fun onSuccess(value: BigInteger) {
                println("number $value")
                continuation.resume(value)
            }

            override fun onFailure(error: Throwable) {
                println("error ${error.message}")
                continuation.resumeWithException(error)
            }
        })
    }
}