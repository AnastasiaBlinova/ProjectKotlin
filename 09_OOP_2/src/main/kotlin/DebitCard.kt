abstract class DebitCard (
    balance: Int
): BankCard (balance){
    abstract val replenish : Int

    override fun replenish() {
        println("Your card replenish on $replenish")
        balance += replenish
    }

    override fun balanceInfo() {
        println("Balance your card: $balance")
    }
}