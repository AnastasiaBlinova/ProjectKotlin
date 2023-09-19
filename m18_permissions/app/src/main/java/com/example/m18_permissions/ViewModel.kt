package com.example.m18_permissions

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ViewModelPhoto (private val photoDao: Dao): ViewModel() {

//    private val _photos = MutableStateFlow<List<PhotosOfSights>>(emptyList())
//    var photos = _photos.asStateFlow()

    val allPhotosOfSights = this.photoDao.getAll()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(1000L),
            initialValue = emptyList()
        )

    fun savePhoto(photo: String, data: String){
        viewModelScope.launch {
            Log.e("SAVE_BD", " SAVEEEE (photo: $photo data: $data")

            photoDao.insert(
                PhotosOfSights(
                    photo = photo,
                    data = data
                )
            )
        }
    }
}