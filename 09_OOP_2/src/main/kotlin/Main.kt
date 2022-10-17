fun main(){
    println("You use card CREDIT SBERBANK")
    println("Credit limit your card: 20.000")
    creditSberbank(CreditSberbank())
    println("==========================")
    println("\nYou use card CREDIT TINKOFF")
    println("Credit limit your card: 100.000")
    creditTinkoff(CreditTinkoff())
    println("==========================")
    println("\nYou use card DEBIT SBERBANK")
    debitSberbank(DebitSberbank())
    println("==========================")
    println("\nYou use card DEBIT TINKOFF")
    debitTinkoff(DebitTinkoff())
}

fun creditSberbank(cS: CreditSberbank){
    //println("Credit limit your card: $cS.creditLimit")
    cS.balanceInfo()
    cS.pay()
    cS.replenish()
    cS.pay()
    cS.replenish()
    cS.available()
}

fun creditTinkoff(cT:CreditTinkoff){
    cT.balanceInfo()
    cT.pay()
    cT.replenish()
    cT.pay()
    cT.replenish()
    cT.available()
}

fun debitSberbank(dS:DebitSberbank){
    dS.balanceInfo()
    dS.pay()
    dS.replenish()
    dS.pay()
    dS.replenish()
    dS.pay()
    dS.available()
}

fun debitTinkoff(dT:DebitTinkoff){
    dT.balanceInfo()
    dT.replenish()
    dT.pay()
    dT.replenish()
    dT.pay()
    dT.replenish()
    dT.available()
}
