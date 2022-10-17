import kotlin.random.Random

open class Animal(var energy: Int, var weight: Int, val ageMax: Int, val name: String) {
    open var ageNow =  Random.nextInt(1,20)

    // open fun isTooOld() {
    //   if (ageNow == ageMax)

    //}

    //  fun tryIncrementAge() {
    //  if (Random.nextInt()) {
    //  }
    // }
    fun sleep(){
        energy += 5
        ageNow += 1
        println("$name - sleeping")
    }
    fun eat(){
        energy += 3
        weight += 1
        if (Random.nextBoolean()) {
            ageNow += 1
        }
        println("$name - eating")
    }
    open fun move(){
        energy -= 5
        weight -= 1
        if (Random.nextBoolean()) {
            ageNow += 1
        }
        print("$name - moving")
    }
    open fun children(): Animal {
        return Animal(energy = (1..10).random(), weight = (1..5).random(), ageMax = ageMax, name = name)
    }
    fun randomAction(a :MutableList<Animal>){
        val count = Random.nextInt(1,4)
        if (count == 1)
            a.add(children())
        if (count == 2)
            move()
        if (count == 3)
            sleep()
        if (count == 4)
            eat()


    }
}