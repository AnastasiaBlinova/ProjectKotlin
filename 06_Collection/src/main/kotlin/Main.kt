fun main() {
    registration()
}

fun registration() {
    println ("Enter a number of phone numbers....")
    val n: Int = (readLine()?. toIntOrNull()?: return)
    if (n>0)
        phoneNumbers(n)
    while(n <=0) {
        println(" ERROR! Enter a different number....")
        var n: Int = (readLine()?.toIntOrNull() ?: return)
        if (n>0)
            phoneNumbers(n)
    }
}

fun phoneNumbers(n: Int) {
    println("Enter $n phone numbers (Enter each number from a new line)")
    var count1: Int = 0
    var phoneNumbers: String
    var phoneList = mutableListOf< String>()
    while (n > count1 ) {
        phoneNumbers = (readLine()?.toString() ?: return)
        count1 += 1
        phoneList.add(phoneNumbers)
    }
    val phoneListFilter = phoneList.filter { it.contains("+7")}
    var phone = (phoneListFilter)
    // println("$phoneList")

    println("Filtered phone numbers: $phoneListFilter")
    val set = phoneListFilter.toSet()
    val quantity = set.size
    //println("$set")

    println ("Number of unique numbers entered: ${quantity}")
    println("The sum of the lengths of all entered phone numbers: ${phoneList.sumOf {it.length}}")

    val phonesWithUser = mutableMapOf<String, String>()
    var userName :String

    //for (phone in phoneList) {
    // println(" Enter your username with you phone number: $phoneList ")
    //  userName = readLine().toString()
    //  phonesWithUser[phoneList.toString()] = userName
    // println("User: $userName. Phone Numbers: $phoneList")

    phoneList.forEach {  phone->
        println(" Enter your username with you phone number: $phoneList ")
        userName = readLine().toString()
        phonesWithUser[phonesWithUser.toString()] = userName
        println("User: $userName. Phone Numbers: $phoneList")
    }

    println("Sort by phone: ${phonesWithUser.toSortedMap()}")
    println("Sort by user: I DON'T KNOW :( ")
}