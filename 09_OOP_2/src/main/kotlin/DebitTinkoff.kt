import kotlin.random.Random

class DebitTinkoff(
    balance: Int = 10000
) : DebitCard(balance) {
    private var pay: Int =  Random.nextInt(1000,4000)
    override var replenish: Int = Random.nextInt(1000,4000)
    private var cash: Int = 0
    private var cashFinish: Int = 0

    override fun replenish() {
        replenish = Random.nextInt(1000,5000)
        cash += (0.1 * replenish).toInt()
        println("\nYour card replenish on: $replenish")
        cashFinish += cash
        balance += replenish
        println("Balance after: $balance. Of these cash: $cash")
        cash = 0
    }

    override fun pay() {
        println("\nYou paid for the purchase on: $pay")
        pay = Random.nextInt(1000,4000)
        if (balance >= pay){
            balance -= pay
            println("Balance after: $balance") }
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