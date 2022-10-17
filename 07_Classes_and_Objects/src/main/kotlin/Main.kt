fun main() {
    val televisorOne = TV(brand = "Sony", model = "m-54", diagonalSize = 32, ofOrOn = "ON")
    val televisorTwo = TV(brand = "Samsung", model = "A-720", diagonalSize = 32, ofOrOn = "OFF")
    val televisorThree = TV(brand = "LG", model = "Z-22", diagonalSize = 24, ofOrOn = "ON")
    val televisorFour = TV(brand = "HUAWEI", model = "RX-4", diagonalSize = 56, ofOrOn = "OFF")

    printInfoOne (televisorOne)
    printInfoOne (televisorTwo)
    printInfoTwo (televisorThree)
    printInfoTwo (televisorFour)
}

fun printInfoOne (tv: TV) {
    print("${tv.brand} ${tv.model}. Diagonal: ${tv.diagonalSize} inches.")
    tv.inclusion()
    tv.channels()
    tv.increaseVolume()
    tv.reduceVolume()
    tv.switchingChannels()
}

fun printInfoTwo (tv: TV) {
    print("${tv.brand} ${tv.model}. Diagonal: ${tv.diagonalSize} inches.")
    tv.inclusion()
    tv.channels()
    tv.increaseVolume()
    tv.reduceVolume()
    tv.switchingChannelsOrder()
}