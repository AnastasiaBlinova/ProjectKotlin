package com.example.m16_architecture.entity

interface UsefulActivity {   // содержит базовую информацию об Aктивности
    val activity: String        //поля из АР|
    val type: String
    val participants: Int
    val price: Double
    val link: String
    val key: String
    val accessibility: Double

}