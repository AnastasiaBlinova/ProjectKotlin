fun main() {
    condition()
}

fun condition() {
    println ("Enter a number....")
    var n: Int = (readLine()?. toIntOrNull()?: return)
    if (n>0)
        fibonachiFun(n)
    while(n <=0) {
        println(" ERROR! Enter a different number....")
        var n: Int = (readLine()?.toIntOrNull() ?: return)
        if (n>0)
            fibonachiFun(n)
    }
}

fun fibonachiFun(n: Int) {
    var count = 0
    var fib1: Int = 0
    var fib2: Int = 1
    var fibonachi = 0
    while (n-2 > count) {
        fibonachi = fib1 + fib2
        fib1 = fib2
        fib2 = fibonachi
        count = count + 1
    }

    println("Sum Fibonachi  $fibonachi")
    return(condition())
}