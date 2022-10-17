object Converters {
    private val dollar = Dollar()
    private val euro = Euro()
    private val pound = Pound()

    fun get(currencyCode: String): CurrencyConverter {
        return when (currencyCode){
            "USD" -> dollar
            "GBP" -> pound
            "EUR" -> euro
            else -> {
                object : CurrencyConverter {
                    override val currencyCode: String = currencyCode
                    override fun convertToRub() {
                        println("Not found")
                    }
                }
            }
        }
    }
}