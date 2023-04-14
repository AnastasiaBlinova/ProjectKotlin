package com.example.todolist

import java.sql.Timestamp

//@Entity(tableName = "list")
data class TaskItemBD(
    //@PrimaryKey
    //@ColumnInfo(name = "id")
    val id: Int,
    //@ColumnInfo(name = "date")
    val date: String,
    //@ColumnInfo(name = "date_start")
    var dateStart: Timestamp,
    //@ColumnInfo(name = "date_finish")
    val dateFinish: Timestamp,
    //@ColumnInfo(name = "name")
    var name: String,
    //@ColumnInfo(name = "description")
    var description: String?
)
