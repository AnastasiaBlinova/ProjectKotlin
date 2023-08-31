package com.example.m9_quiz_location

import java.text.SimpleDateFormat
import java.util.Calendar


fun main() {
  //val format = SimpleDateFormat("dd-MM-yy hh:mm")
  val dateFormat = SimpleDateFormat("dd-MM-yy")
  val calendar = Calendar.getInstance()
  val date = calendar.time
  val formatter = dateFormat.format(date)
  println(formatter)
  //println(calendar.timeInMillis)               // время в милисекундах
  //calendar.set(Calendar.YEAR, 1999)            // если нужен конкретный год
 // val day  = calendar.get(Calendar.DAY_OF_MONTH)
 // val month = calendar.get(Calendar.MONTH) + 1   // еденичка нужна для корректного номера месяца
 // val year = calendar.get(Calendar.YEAR)

  //println("$day / $month / $year")
}