package com.example.m16_architecture.data

import android.content.ContentValues
import android.util.Log
import com.example.m16_architecture.entity.UsefulActivity
import kotlinx.coroutines.delay
import javax.inject.Inject

class Repository  @Inject constructor (){
    suspend fun getActivity(): UsefulActivity?{
        Log.d(ContentValues.TAG, "getActivity: Старт ")
        delay(3000)
        return  try {
            Log.d(ContentValues.TAG, "getActivity: OK ")
            RetrofitServices.searchApi.getActivity()
        } catch (e:Exception){
            Log.d(ContentValues.TAG, "getActivity: NULL ")
            null}

    }
}