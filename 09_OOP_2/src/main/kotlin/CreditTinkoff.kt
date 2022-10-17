import kotlin.random.Random

class CreditTinkoff(
    balance : Int = 10000
): CreditCard(balance) {
    override var creditLimit: Int = 100000
    override var replenish: Int = Random.nextInt(100,40000)
    override var pay: Int = Random.nextInt(100,50000)
    override var cash: Int = 0
    private var cashFinish = 0

    override fun replenish() {
        replenish = Random.nextInt(100,40000)
        println("Your card replenish on: $replenish")
        if (creditLimit < 100000 ){
            if (replenish > (100000 - creditLimit )){
                val remnant = (replenish - (100000 - creditLimit))
                balance += remnant
                creditLimit = 100000}
            else {
                creditLimit += replenish
                balance = 0 }
        }
        else balance += replenish
        println("Credit limit after: $creditLimit")
        println("Balance after: $balance")
        cash = 0
    }
    override fun available() {
        println("\nCredit limit your card: $creditLimit")
        balanceInfo()
        println("You deserve cashback for using credit funds: $cashFinish. Now we will add it to the card!")
        balance += cashFinish
        println("Finish balance your card: $balance")

    }
    override fun pay() {
        pay = Random.nextInt(100,50000)
        println("\nYou paid for the purchase on: $pay")
        if (balance >= pay) {
            balance -= pay
            println("Balance after pay: $balance")
            println("Credit limit after pay: $creditLimit\n")
        }
        else {
            creditLimit -= (pay - balance)
            cash = (0.01 * (pay - balance)).toInt()
            balance = 0
            cashFinish += cash
            println("Balance after: $balance. Of these cash: $cash")
            println("Credit limit after pay: $creditLimit\n")
            cash = 0
        }
    }
}
