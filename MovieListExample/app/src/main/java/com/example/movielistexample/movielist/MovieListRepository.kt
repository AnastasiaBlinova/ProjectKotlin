package com.example.movielistexample.movielist

import com.example.movielistexample.api.retrofit
import com.example.movielistexample.models.Movie

class MovieListRepository {                                    //вызывается viewModel
    suspend fun getPremieres(year: Int, month: String): List<Movie>{
        return retrofit.movies(year,month).items
    }
}