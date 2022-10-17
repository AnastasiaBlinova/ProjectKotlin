open class Euro : CurrencyConverter {
    override val currencyCode: String = "EUR"

    override fun convertToRub() {
        println("Enter amount of money:")
        val amountMoney = readLine()?.toInt()
        if (amountMoney != null) {
            println("$amountMoney ruble = ${amountMoney * 66.32} %EUR%")
        }
        else
            println("Enter amount of money:")
    }
}