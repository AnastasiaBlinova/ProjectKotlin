import Channels.getRandomChannels
import kotlin.random.Random

class TV(val brand: String, val model: String, val diagonalSize: Int, private var ofOrOn: String) {

    private companion object maxValume {
        const val maxValume = 100
    }

    fun inclusion() {
        if (ofOrOn == "ON")
            println(" TV - on")
        if (ofOrOn == "OFF")
            println(" TV - off")

    }

    fun channels() {
        val channels = getRandomChannels()
        println("Channels List: $channels")
    }

    fun increaseVolume() {
        val volume = 25
        val randomOne = Random.nextInt(1, 75)
        val MakeItLouder = volume + randomOne
        println("TV volume: $volume. After increasing by $randomOne TV volume: $MakeItLouder")
    }

    fun reduceVolume() {
        val volume = 25
        val randomeTwo = Random.nextInt(1, 25)
        val MakeItQuieter = volume - randomeTwo
        println("TV volume: $volume. After reduce by $randomeTwo TV volume: $MakeItQuieter")
    }

    fun switchingChannels() {
        println("TV remote is waiting for you press! Enter number TV channels:")
        val numberChannel = readLine()
        if (ofOrOn == "ON")
            println("You have turned on channel: $numberChannel. Enjoy your viewing!\n")
        if (ofOrOn == "OFF")
            println("TV - on. You have turned on channel: $numberChannel. Enjoy your viewing!\n")

    }

    fun switchingChannelsOrder() {
        val randomeThree = Random.nextInt(1, 20)
        println("To switch the channel up, press: <+>. To switch the channel down, press: <->.")
        val switchChannel: String? = readLine()
        if (ofOrOn == "ON" && switchChannel == "+")
            println("You watched: $randomeThree. And now you watch: ${randomeThree + 1}.\n")
        if (ofOrOn == "ON" && switchChannel == "+" && randomeThree == 20)
            println("You watched: $randomeThree. And now you watch: 1.\n")
        if (ofOrOn == "ON" && switchChannel == "-" && randomeThree == 1)
            println("You watched: $randomeThree. And now you watch: 20.\n")
        if (ofOrOn == "ON" && switchChannel == "-")
            println("You watched: $randomeThree. And now you watch: ${randomeThree - 1}\n")
        if (ofOrOn == "OFF")
            println("TV - on. You have turned on channel: $randomeThree. Enjoy your viewing!\n")


    }
}