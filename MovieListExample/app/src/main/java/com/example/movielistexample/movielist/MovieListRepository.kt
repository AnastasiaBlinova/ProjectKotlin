package com.example.movielistexample.movielist

import com.example.movielistexample.api.retrofit
import com.example.movielistexample.models.Movie
import kotlinx.coroutines.delay

class MovieListRepository {                                    //вызывается viewModel
    suspend fun getPremieres(year: Int, month: String): List<Movie>{
        delay(1000)
        return retrofit.movies(year,month).items
    }
}