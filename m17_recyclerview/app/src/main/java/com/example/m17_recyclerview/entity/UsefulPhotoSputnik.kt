package com.example.m17_recyclerview.entity

import com.example.m17_recyclerview.domain.Camera
import com.example.m17_recyclerview.domain.Rover

interface UsefulPhotoSputnik {
    val id1: Int
    val sol: Int
    val camera: Camera
    val imgSrc: String
    val earthDate: String
    val rover: Rover
}