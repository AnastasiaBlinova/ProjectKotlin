package com.example.m18_permissions

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sights")
data class PhotosOfSights(
    @PrimaryKey
    @ColumnInfo(name = "photo")
    var photo: String,
    @ColumnInfo(name = "data")
    var data: String
)
