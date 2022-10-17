open class Pound : CurrencyConverter {
    override val currencyCode: String = "GBP"

    override fun convertToRub() {
        println("Enter amount of money:")
        val amountMoney = readLine()?.toInt()
        if (amountMoney != null) {
            println("$amountMoney ruble = ${amountMoney * 77} %GBR%")
        }
        else
            println("Enter amount of money:")
    }
}