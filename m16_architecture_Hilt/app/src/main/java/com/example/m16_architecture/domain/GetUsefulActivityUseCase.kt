package com.example.m16_architecture.domain

import android.content.ContentValues
import android.util.Log
import com.example.m16_architecture.data.Repository
import com.example.m16_architecture.data.UsefulActivityDto
import com.example.m16_architecture.entity.UsefulActivity
import javax.inject.Inject

class GetUsefulActivityUseCase @Inject constructor (
    private val usefulActivitiesRepository: Repository
) {

    suspend fun execute(): UsefulActivity? {
        Log.d(ContentValues.TAG, "execute: Старт ")
        val data = usefulActivitiesRepository.getActivity()
        Log.d(ContentValues.TAG, "execute: Финиш $data ")
        return data

    }
}