fun main() {
    println("Enter International Currency Code:")
    val currencyCode = readLine()
    if (currencyCode != null)
    {
        Converters.get(currencyCode).convertToRub()
    }
}