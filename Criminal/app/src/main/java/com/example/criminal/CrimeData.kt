package com.example.criminal

import java.util.Date
import java.util.UUID

data class CrimeData(
    val id: UUID = UUID.randomUUID(),      //ГЕНЕРИРУЕТ УНИКАЛЬНЫЙ ИДЕНТИФИКАТОР
    var title: String = "",
    var date: Date = Date(),                //В КОНСТРУКТОРЕ ТЕКУЩАЯ ДАТА
    var isSolved: Boolean = false
    )
