package com.example.movielistexample.movielist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movielistexample.models.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieListViewModel private constructor(
    private val repository: MovieListRepository
) : ViewModel() {
    constructor() : this (MovieListRepository())

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies = _movies.asStateFlow()

    init{                           //при создании viewModel вызывается функция loadPremieres()
        loadPremieres()
    }

    private fun loadPremieres(){
        viewModelScope.launch ( Dispatchers.IO){
            kotlin.runCatching {                            // припомощи ретрофита загружается список премьер за январь 2022
                repository.getPremieres(2022, "JANUARY")
            }.fold(
                onSuccess = {_movies.value = it},    // после успешной загрузки данных список помещается в StateFlow, на который будет подписан фрагмент
                onFailure = { Log.d("MovieListViewModel", it.message ?: "")}
            )
        }
    }
}



























