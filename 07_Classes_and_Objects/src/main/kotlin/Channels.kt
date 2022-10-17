import kotlin.random.Random

object Channels {
    var channelsList = mapOf(
        1 to "Karysel",
        2 to "Sport",
        3 to "Myz-TV",
        4 to "Mir",
        5 to "Friday",
        6 to "TNT",
        7 to "STS",
        8 to "Star",
        9 to "NTV",
        10 to "REN-TV",
        11 to "One channel",
        12 to "Two channel",
        13 to "Three channel",
        14 to "Four channel",
        15 to "Five channel",
        16 to "Six channel",
        17 to "Seven channel",
        18 to "Eight channel",
        19 to "Nine channel",
        20 to "Ten channel",
    )
    fun getRandomChannels (): MutableMap<Int, String> {
        val key = channelsList.keys.toList()
        val mixChanel = channelsList.values.shuffled()
        val size = Random.nextInt(1, 20)
        val newList = mutableMapOf<Int, String>()
        for (i in 0..size) {
            val pair: Pair<Int, String> = Pair(key[i],mixChanel[i])
            newList[pair.first] = pair.second

        }

        return newList

    }
}