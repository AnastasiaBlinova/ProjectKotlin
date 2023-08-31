package com.example.m17_recyclerview.presentation

import android.util.Log
import com.example.m17_recyclerview.data.Repository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.m17_recyclerview.domain.PhotoSputnik
import com.example.m17_recyclerview.domain.Photos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ViewModel private constructor(
): ViewModel() {
    private val repository = Repository()

    private val _isLoading = MutableStateFlow(false)//заведем отдельный стэйт флоу отвечающий за индикатор загруски
    val isLoading = _isLoading.asStateFlow()
//     private val _photos = MutableStateFlow<List<PhotoSputnik>>(emptyList())              // 1 (PhotoSputnik)
    private val _photos = MutableStateFlow<List<Photos>>(emptyList())                       // 2 (List<Photos>)


    var photos = _photos.asStateFlow()

// ****** ТЕСТИЛА Для ПОСТРАНИЧНОЙ ЗАГРУЗКИ

    var pagedSputnik: Flow<PagingData<Photos>> = Pager(     // + 3 (Paging) переменная для
        config = PagingConfig(25),               // + 3 (Paging) постраничной
        initialKey = null,
        pagingSourceFactory = { PagginSource() }           // + 3 (Paging) загрузки
    ).flow.cachedIn(viewModelScope)                        // + 3 (Paging) данных


    init {
        loadPhotoSputnik()
    }


//    fun loadPhotoSputnik(){                                                   // 1 (PhotoSputnik)
//        Log.e("","loadPhotoSputnik START")                                    // 1 (PhotoSputnik)
//        viewModelScope.launch(Dispatchers.IO){                                // 1 (PhotoSputnik)
//            kotlin.runCatching {                                              // 1 (PhotoSputnik)
//                _isLoading.value = true                                       // 1 (PhotoSputnik)
//                repository.getPhotoSputnik()                                  // 1 (PhotoSputnik)
//            }.fold(                                                           // 1 (PhotoSputnik)
//                onSuccess = {_photos.value = listOf(it) },                    // 1 (PhotoSputnik)
//                onFailure = {Log.d("", it.message ?: "")}                     // 1 (PhotoSputnik)
//            )                                                                 // 1 (PhotoSputnik)
//            _isLoading.value = false                                          // 1 (PhotoSputnik)
//        }                                                                     // 1 (PhotoSputnik)
//    }                                                                         // 1 (PhotoSputnik)

// ****** ТЕСТИЛА Для ПОСТРАНИЧНОЙ ЗАГРУЗКИ

    fun loadPhotoSputnik(){                                                                 // 2 (List<Photos>)
        Log.e("","loadPhotoSputnik START")                                         // 2 (List<Photos>)
        viewModelScope.launch(Dispatchers.IO){                                              // 2 (List<Photos>)
            kotlin.runCatching {                                                            // 2 (List<Photos>)
                _isLoading.value = true                                                     // 2 (List<Photos>)
               repository.getPhotoSputnik(1)                                         // 2 (List<Photos>)
            }.fold(                                                                         // 2 (List<Photos>)
                onSuccess = {_photos.value = it },                                          // 2 (List<Photos>)
                onFailure = {Log.d("", it.message ?: "")}                          // 2 (List<Photos>)
            )                                                                               // 2 (List<Photos>)
            _isLoading.value = false                                                        // 2 (List<Photos>)
        }                                                                                   // 2 (List<Photos>)
    }                                                                                       // 2 (List<Photos>)

    private val _state = MutableStateFlow<State>(State.Result)
    val state = _state.asStateFlow()

    private val _photoSputnikModel = Channel<PhotoSputnik> ()
    val photoSputnikModel = _photoSputnikModel.receiveAsFlow()

    private val _error = Channel<String>()
    val error = _error.receiveAsFlow()




//    fun loadPhotoSputnik() = viewModelScope.launch {
//        _state.value = State.Loading
//        delay(500)
//        try {
//            Log.e("", "LoadPhotoSputnik - start")
//            _photoSputnikModel.send(repository.getPhotoSputnik(/*1*/))
//        }catch (e:Exception){
//            _state.value = State.Error("Error: ${e.message}")
//        }
//        _state.value = State.Result
//    }
}