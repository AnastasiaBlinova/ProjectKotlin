package Lesson_13_4

import java.math.BigInteger
import kotlin.concurrent.thread
import kotlin.random.Random
import kotlin.random.asJavaRandom
import kotlin.system.measureTimeMillis


fun main() {
    println("Program start: ${Thread.currentThread().name}")
    magicNumber(object : Callback{
        override fun onSuccess(value: BigInteger) {
            println("first number = $value")
        }

        override fun onFailure(error: Throwable) {
            println("Error occurred: ${error.message}")
        }

    })
    magicNumber(object : Callback{
        override fun onSuccess(value: BigInteger) {
            println("second number = $value")
        }

        override fun onFailure(error: Throwable) {
            println("Error occurred: ${error.message}")
        }

    })
 //   println(magicNumber())
}
//Напишем функцию, которая рассчитывает очень большое число и вызовем несколько таких функций
fun magicNumber(callback: Callback){
    //создадим отдельный поток
    thread {
        println("Calculation start: ${Thread.currentThread().name}")
        // добавим ограничение на время
        val number: BigInteger
        val time = measureTimeMillis {
            number = BigInteger.probablePrime(4000, Random.asJavaRandom())
        }
        if (time > 200)
            callback.onFailure(Throwable("Calculation was too long"))
        else
          //       val number = BigInteger.probablePrime(4000, Random.asJavaRandom())
 //       return number // из потока нельзя возвращать значение, во время работы програмы
        //После того, как расчитаем число нужно вызвать функцию у колбэка
        callback.onSuccess(number)
    }
}

interface Callback {
    fun onSuccess(value: BigInteger)
    fun onFailure(error: Throwable)
}