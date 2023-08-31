package com.example.m17_recyclerview.domain

import android.content.ContentValues
import android.util.Log
import com.example.m17_recyclerview.data.Repository
import com.example.m17_recyclerview.entity.UsefulPhotoSputnik
import javax.inject.Inject

class UseCase @Inject constructor (
    private val usefulRepository: Repository
) {
//    suspend fun execute(page: Int): PhotoSputnik/*UsefulPhotoSputnik?*/ {
//        Log.d(ContentValues.TAG, "execute: Старт ")
//        val data = usefulRepository.getPhotoSputnik(page)
//        Log.d(ContentValues.TAG, "execute: Финиш $data ")
//        return data
//
//    }
}