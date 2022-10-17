import kotlin.random.Random

class Dog(
    energy: Int,
    weight: Int,
    ageMax: Int,
    name: String,
    override var ageNow: Int = Random.nextInt(1,15)
) : Animal(energy,weight,ageMax,name) {

    override fun move() {
        super.move()
        println("( Run )")
    }
    override fun children(): Animal {
        super.children()
        val twoDog = Animal(energy = (1..10).random(), weight = (1..5).random(), ageMax = ageMax, name = name)
        println("$name was born! Characteristics: energy = $energy, weight = $weight, age max = $ageMax")
        return twoDog

    }
}