package com.example.m17_recyclerview.domain

import com.example.m17_recyclerview.entity.UsefulPhotoSputnik
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhotoSputnik(
    @Json( name = "photos")
    val photos: List<Photos>,             // помнить, что если [] то это список
)

@JsonClass(generateAdapter = true)
data class Photos(
    @Json( name = "id")
    override val id1: Int,
    @Json( name = "sol")
    override val sol: Int,
    @Json( name = "camera")           //Составной объект, нужна детальность
    override val camera: Camera,               //Составной объект,, нужна детальность. Будет несколько слоев!
    @Json( name = "img_src")
    override val imgSrc: String,
    @Json( name = "earth_date")
    override val earthDate: String,
    @Json( name = "rover")
    override val rover: Rover

    ): UsefulPhotoSputnik

@JsonClass(generateAdapter = true)
data class Camera(
    @Json( name = "id")
    val id2: Int,
    @Json( name = "name")
    val name1: String,
    @Json( name = "rover_id")
    val roverId: Int,
   @Json( name = "full_name")
    val fullName: String
)

@JsonClass(generateAdapter = true)
data class Rover(
    @Json( name = "id")
    val id3: Int,
    @Json( name = "name")
    val name2: String,
    @Json( name = "landing_date")
    val landingDate: String,
    @Json( name = "launch_date")
    val launchDate: String,
   @Json( name = "status")
    val status: String,
    @Json( name = "max_sol")
    val maxSol: Int,
    @Json( name = "max_date")
    val maxDate: String,
    @Json( name = "total_photos")
    val totalPhotos: Int,
    @Json( name = "cameras")
    val cameras: List<Cameras>
)

@JsonClass(generateAdapter = true)
data class Cameras(
    @Json( name = "name")
    val name3: String,
    @Json( name = "full_name")
    val full_name: String
)