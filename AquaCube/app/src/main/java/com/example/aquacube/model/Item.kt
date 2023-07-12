package com.example.aquacube.model

class Item {
    var id: String? = null
    var time: String? = null
    var name: String? = null
    var count: Int? = null

    constructor(){}
    constructor(
        time: String?,
        name: String?,
        count: Int
    ){
        this.time = time
        this. name =  name
        this.count = count
    }
}