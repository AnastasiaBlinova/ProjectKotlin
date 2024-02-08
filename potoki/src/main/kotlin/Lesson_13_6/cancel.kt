package Lesson_13_6

import kotlinx.coroutines.*

suspend fun main(){
    val job = scope.launch {
        var i = 0
        while(true){
            yield()//+++++++
            println(i++)
    //        Thread.sleep(500)
            delay(5000)
        }
    }
    scope.launch {
        delay(3000)
        println("cancel job")
        job.cancel()
    }

    (scope.coroutineContext.job as? CompletableJob)?.let {
        it.complete()
        it.join()
    } ?: throw IllegalStateException()
}
suspend fun cancellableSuspend(){
    suspendCancellableCoroutine<Unit> {cancellableContinuation ->
        cancellableContinuation.invokeOnCancellation {
            //some code
        }
        scope.launch {
            while(true){
                var i = 0
                println(i++)
                //        Thread.sleep(500)
                delay(5000)
            }
        }
    }
}