import kotlin.random.Random

class CreditSberbank(
    balance : Int = 2000
): CreditCard(balance) {
    override var creditLimit: Int = 20000
    override var replenish: Int = Random.nextInt(100,1000)
    override var pay: Int = Random.nextInt(100,10000)
    override var cash: Int = 0
    private var cashFinish = 0

    override fun replenish() {
        replenish = Random.nextInt(100,5000)
        println("Your card replenish on: $replenish")
        if (creditLimit < 20000 ){
            if (replenish > (20000 - creditLimit )){
                val remnant = (replenish - (20000 - creditLimit))
                balance += remnant
                creditLimit = 20000}
            else {
                creditLimit += replenish
                balance = 0 }
        }
        else balance += replenish
        cash += (0.01 * replenish).toInt()
        cashFinish += cash
        println("Credit limit after: $creditLimit")
        println("Balance after: $balance. Of these cash: $cash")
        cash = 0
    }
    override fun available() {
        println("\nCredit limit your card: $creditLimit")
        balanceInfo()
        println("You deserve cashback for replenish card: $cashFinish. Now we will add it to the card!")
        balance += cashFinish
        println("Finish balance your card: $balance")

    }
    override fun pay() {
        pay = Random.nextInt(100,6000)
        println("\nYou paid for the purchase on: $pay")
        if (balance >= pay) {
            balance -= pay
            println("Balance after pay: $balance")
            println("Credit limit after pay: $creditLimit\n")
        }
        else{
            creditLimit -= (pay - balance)
            balance = 0
            println("Balance after pay: $balance")
            println("Credit limit after pay: $creditLimit\n")
        }
    }
}