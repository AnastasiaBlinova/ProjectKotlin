import kotlin.random.Random

class Fish(
    energy: Int,
    weight: Int,
    ageMax: Int,
    name: String,
    override var ageNow: Int = Random.nextInt(1,3)
) : Animal(energy,weight,ageMax,name) {

    override fun move() {
        super.move()
        println("( Swim )")
    }
    override fun children(): Animal {
        super.children()
        val twoFish = Animal(energy = (1..10).random(), weight = (1..5).random(), ageMax = ageMax, name = name)
        println("$name was born! Characteristics: energy = $energy, weight = $weight, age max = $ageMax")
        return twoFish

    }
}