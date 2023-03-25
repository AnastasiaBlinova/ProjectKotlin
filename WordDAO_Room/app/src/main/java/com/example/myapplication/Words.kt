package com.example.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list")
data class Words(
    @PrimaryKey
    @ColumnInfo(name = "words")
    val words: String,
    @ColumnInfo(name = "count")
    var count: Int
)
