package com.example.todolist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

//@Entity(tableName = "list")
data class Deeds(
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
    var name: String?,
    //@ColumnInfo(name = "description")
    var description: String?
)
