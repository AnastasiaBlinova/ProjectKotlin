package com.example.movielistexample.models

data class Movie(
    val kinipoiskId: Int,
    val nameRu: String,
  //  val films: String,
    val posterUri: String,
    val posterUriPreView: String,
    val genres: List<Genre>,
    val premierRu: String,
    val countries: List<Country>
)

data class Genre(
    val genre:String
)
data class Country(
    val country: String
)
