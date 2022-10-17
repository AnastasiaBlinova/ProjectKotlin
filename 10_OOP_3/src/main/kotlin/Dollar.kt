open class Dollar : CurrencyConverter {
    override val currencyCode: String = "USD"

    override fun convertToRub() {
        println("Enter amount of money:")
        val amountMoney = readLine()?.toInt()
        if (amountMoney != null) {
            println("$amountMoney ruble = ${amountMoney * 61.23} %USD%")
        }
        else
            println("Enter amount of money:")
    }
}