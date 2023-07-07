package com.example.movielistexample.models

class MovieList (      //сам список фильмов описывается здесь в соответствии с документацией Api in Repository вызывается api
    val total: Int,
    val item: List<Movie>
)