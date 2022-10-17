import kotlin.random.Random

open class Bird (
    energy: Int,
    weight: Int,
    ageMax: Int,
    name: String,
    override var ageNow: Int = Random.nextInt(1,5)
) : Animal(energy,weight,ageMax,name) {
    override fun move() {
        super.move()
        println("( Fly )")
    }

    override fun children(): Animal {
        super.children()
        val twoBird = Animal(energy = (1..10).random(), weight = (1..5).random(), ageMax = ageMax, name = name)
        // println("$name was born! Characteristics: energy = $energy, weight = $weight, age max = $ageMax")
        return twoBird

    }
}