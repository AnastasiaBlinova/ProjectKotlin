package com.example.list

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*
@Entity(tableName = "task_item_table")
class TaskItemBD (
    @ColumnInfo(name = "name")
    var name:String,
    @ColumnInfo(name = "desc")
    var desc: String,
    @ColumnInfo(name = "date")
    var date: String,
    @ColumnInfo(name = "dueTimeStart")
    var dueTimeStart: String,
    @ColumnInfo(name = "dueTimeFinish")
    var dueTimeFinish: String?,
    @ColumnInfo(name = "completedDateString")
    var completedDateString: String?,
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
){

    fun completedDate(): LocalDate? = if(completedDateString == null) null
        else LocalDate.parse(completedDateString, dateFormatter)

    fun dueTimeStart(): LocalTime? = //if (dueTimeStart == null) null else
         LocalTime.parse(dueTimeStart, timeFormatter)

    fun dueTimeFinish(): LocalTime? = if (dueTimeFinish == null) null
    else LocalTime.parse(dueTimeFinish, timeFormatter)

    fun isCompleted() = completedDate() != null

    fun imageResource(): Int = if (isCompleted()) R.drawable.checked_button else R.drawable.unchecked_button

    fun imageColor(context: Context): Int =if (isCompleted()) purple(context) else black(context)

    private fun purple(context: Context) = ContextCompat.getColor(context, R.color.purple_500)

    private fun black(context: Context) = ContextCompat.getColor(context, R.color.black)

    companion object{
        val timeFormatter: DateTimeFormatter = DateTimeFormatter.ISO_TIME
        val dateFormatter: DateTimeFormatter = DateTimeFormatter.ISO_DATE
    }












}