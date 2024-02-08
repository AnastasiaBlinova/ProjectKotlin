package Lesson_13_6

import Lesson_13_4.Callback
import Lesson_13_4.magicNumber
import kotlinx.coroutines.*
import java.math.BigInteger
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
    println("error handler - ${throwable.message}")
}

//val parentJob = Job()  // 1
//val scope = CoroutineScope(parentJob + Dispatchers.Default) // 1
//val scope = CoroutineScope( Dispatchers.Default) // 2
val scope = CoroutineScope( SupervisorJob() + Dispatchers.Default + exceptionHandler) //3
// SupervisorJob() 5 - в случае ошибки не отменяет все  (18)
 suspend fun  main(){


 //   runBlocking {
//
//        scope.launch {
//            println("Start runBlocking...")
//            // doSomeWork()
//            suspendMagicNumber()
//            println("Finish runBlocking...")
//        }
//        println("Start working..")
     canceledCoroutine() //ошибка в одной отменяет все остальные
     //2
     (scope.coroutineContext.job as? CompletableJob)?.let {
         it.complete()
         it.join()
     } ?: throw  IllegalStateException()
    // parentJob.complete()    //1 переводим в состояние завершения
    // parentJob.join()        //1 дождемся когда она перейдет в состояние - завершен
   //     scope.coroutineContext.job.join()
 //   }
}

//отмена всех дочерних корунтин при появлении ошибки
//ошибка в одной отменяет все остальные
fun canceledCoroutine(){
    scope.launch {
        delay(3000)
        error("test exception")
    }
    scope.launch {
        var i = 0
        while (true){
            delay(200)
            println(i++)
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