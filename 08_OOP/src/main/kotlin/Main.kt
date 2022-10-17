fun main(){
    var reserve = NatureReserve()
    val animal = reserve.animals
    for (o in 0..4)
    {
        for (element in animal)
        {
            element.randomAction(reserve.animalsList)
        }
        animal.addAll(reserve.animalsList)
        reserve.animalsList.clear()
    }

    /*val oneBird = Bird(5,1, 5,"Luna" )
    val oneFish = Fish(6, 2,3,"Gold Fish")
    val oneDog = Dog(7,3,15,"Ralf")
    val oneJaguar = Jaguar(8,4,25,"Aslan")

    oneBird.randomAction()
    oneFish.randomAction()
    oneDog.randomAction()
    oneJaguar.randomAction()

 println("\n")
    oneBird.randomAction()
    oneFish.randomAction()
    oneDog.randomAction()
    oneJaguar.randomAction()
    println("\n")
    oneBird.randomAction()
    oneFish.randomAction()
    oneDog.randomAction()
    oneJaguar.randomAction()
    println("\n")
    oneBird.randomAction()
    oneFish.randomAction()
    oneDog.randomAction()
    oneJaguar.randomAction()*/
}