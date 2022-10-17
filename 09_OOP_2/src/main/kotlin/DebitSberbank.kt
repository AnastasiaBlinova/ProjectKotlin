import kotlin.random.Random

class DebitSberbank(
    balance : Int = 15000
) : DebitCard(balance) {
    private var pay: Int =  Random.nextInt(1000,15000)
    override var replenish: Int = Random.nextInt(1000,4000)
    private var cash: Int = 0
    private var cashFinish: Int = 0

    override fun replenish() {
        replenish = Random.nextInt(1000,4000)
        println("\nYour card replenish on: $replenish")
        balance += replenish
        println("Balance after: $balance")
    }

    override fun pay() {
        pay = Random.nextInt(5000,15000)
        cash = (0.1 * pay).toInt()
        println("\nYou paid for the purchase on: $pay")
        if (balance >= pay) {
            balance -= pay
            cashFinish += cash
            println("Balance after: $balance. Of these cash: $cash")
            cash = 0
        }
        else println("Insufficient funds!")
    }

    override fun available() {
        println("\n")
        balanceInfo()
        println("You deserve cashback for replenish card: $cashFinish. Now we will add it to the card!")
        balance += cashFinish
        println("Finish balance your card: $balance")
    }
}
