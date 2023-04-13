package com.example.list

import java.time.LocalDate
import java.time.LocalTime
import java.util.*

class TaskItemBD (
    var name:String,
    var desc: String,
    var dueTime: LocalTime?,
    var completedDate: LocalDate?,
    var id: UUID = UUID.randomUUID()
)