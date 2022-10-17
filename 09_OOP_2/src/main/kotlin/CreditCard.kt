abstract class CreditCard (
    balance: Int,
): BankCard(balance ) {
    abstract var creditLimit:Int
    abstract val replenish: Int
    abstract val pay: Int
    abstract var cash: Int

    override fun replenish() {
        if (creditLimit < 1000 ){
            if (balance > 1000 - creditLimit ){
                creditLimit += balance - (1000 - creditLimit)
                balance -= (1000 - creditLimit)
            }
            if (balance < 1000 - creditLimit ){
                creditLimit += balance
                balance = 0
                balance += ((1000 - creditLimit) * 0.1).toInt()
                println("balance cash $balance")
            }
        }
        else balance += replenish
    }

    override fun pay() {
        if (balance >= pay) {
            balance -= pay
            balance += cash
        }
        if (balance < pay){
            creditLimit -= pay - balance
            balance = 0

        }
    }

    override fun balanceInfo() {
        println("Balance your card: $balance")
    }
}