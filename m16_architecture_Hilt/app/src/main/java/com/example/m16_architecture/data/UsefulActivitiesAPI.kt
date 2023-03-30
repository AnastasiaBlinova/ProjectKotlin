package com.example.m16_architecture.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://www.boredapi.com/api/"

object RetrofitServices {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val searchApi: LoadUsefulActivity = retrofit.create(LoadUsefulActivity::class.java)
}
interface LoadUsefulActivity{
    @GET("activity/")
    suspend fun getActivity(): UsefulActivityDto   //UsefulActivityDto наследует интерфейс UsefulActivity
}