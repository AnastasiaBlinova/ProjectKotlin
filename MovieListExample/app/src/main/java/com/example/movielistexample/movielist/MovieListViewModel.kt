package com.example.movielistexample.movielist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.movielistexample.models.Movie
import com.example.movielistexample.pagedmovielist.MoviePagingSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MovieListViewModel private constructor(
    private val repository: MovieListRepository
) : ViewModel() {
    constructor() : this (MovieListRepository())

    private val _isLoading = MutableStateFlow(false)//заведем отдельный стэйт флоу отвечающий за индикатор загруски
    val isLoading = _isLoading.asStateFlow()

    val filterEnabled= MutableStateFlow(false)

    val pagedMovies: Flow<PagingData<Movie>> = Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = {MoviePagingSource()}
    ).flow.cachedIn(viewModelScope)

//    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
//    val movies: StateFlow<List<Movie>> = combine(_movies, filterEnabled){ movies, filterEnabled ->
//        if (filterEnabled)
//            movies.filter { movie ->
//                movie.countries.any { it.country == "Россия" }
//            }
//        else movies
//    }.stateIn(
//        scope = viewModelScope,
//        started = SharingStarted.Eagerly,
//        initialValue = _movies.value
//    )

//    init{                           //при создании viewModel вызывается функция loadPremieres()
//        loadPremieres()
//    }
//
//    private fun loadPremieres(){
//        viewModelScope.launch ( Dispatchers.IO){
//            kotlin.runCatching {                            // припомощи ретрофита загружается список премьер за январь 2022
//                _isLoading.value = true  //как только начинается загрузка в StateFlow записывается ТРУ
//                repository.getPremieres(2022, "JANUARY")
//            }.fold(
//                onSuccess = {_movies.value = it},    // после успешной загрузки данных список помещается в StateFlow, на который будет подписан фрагмент
//                onFailure = { Log.d("MovieListViewModel", it.message ?: "")}
//            )
//            _isLoading.value = false // после окончания загрузки ФОЛС
//        }
//    }
}



























