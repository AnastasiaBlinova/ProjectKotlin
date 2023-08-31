package com.example.m17_recyclerview.data

import com.example.m17_recyclerview.data.LoadPhotoListApi.Companion.BASE_URL
import com.example.m17_recyclerview.domain.PhotoSputnik
import com.example.m17_recyclerview.domain.Photos
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface LoadPhotoListApi {
    @Headers("Accept: application/json") //read api doc
    @GET("/mars-photos/api/v1/rovers/curiosity/photos")
    suspend fun photoSputnikList(
        @Query("page") page: Int = 1,
        @Query("sol") sol: Int = 1000,
        @Query("api_key") api_key:String = API_KEY
    ): PhotoSputnik


     companion object{
        const val API_KEY = "xAQxI2Lo0bO5zB4eD1pkzA9TFhNeL6dkbspqEEmr"
        const val BASE_URL = "https://api.nasa.gov"
    }
}

object RetrofitServises {
    val retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
    val searchApi: LoadPhotoListApi = retrofit.create(LoadPhotoListApi::class.java)
}

