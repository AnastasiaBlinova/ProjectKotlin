package com.example.m17_recyclerview.data

import android.util.Log
import com.example.m17_recyclerview.domain.PhotoSputnik
import com.example.m17_recyclerview.domain.Photos
import com.example.m17_recyclerview.entity.UsefulPhotoSputnik
import kotlinx.coroutines.delay
import javax.inject.Inject

class Repository @Inject constructor (){

//    suspend fun getPhotoSputnik(): PhotoSputnik {
//        delay(1000)
//        Log.e("", "getPhotoSputnik START" )
//        val  partPhoto  = RetrofitServises.searchApi.photoSputnikList()
//        Log.e( "","Return ${partPhoto.photos}" )
//        return partPhoto
//    }

// ****** ТЕСТИЛА Для ПОСТРАНИЧНОЙ ЗАГРУЗКИ

    suspend fun getPhotoSputnik(page: Int): List<Photos> {
        delay(1000)
            Log.e("", "getPhotoSputnik START" )
            val  partPhoto  = RetrofitServises.searchApi.photoSputnikList(page)
            Log.e( "","Return ${partPhoto.photos}" )
            return partPhoto.photos
    }

}