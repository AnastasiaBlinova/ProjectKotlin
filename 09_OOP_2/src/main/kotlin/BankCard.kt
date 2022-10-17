abstract class BankCard(
    var balance : Int,
) {
    abstract fun replenish() // пополнить
    abstract fun pay()
    abstract fun balanceInfo()
    abstract fun available()

}