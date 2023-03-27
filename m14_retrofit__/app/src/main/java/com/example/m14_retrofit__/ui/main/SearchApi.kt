package com.example.m14_retrofit__.ui.main

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

private const val BASE_URL = "https://randomuser.me/"                 //адрес ссылки

object RetrofitServices {                                               //Создаем инстанс ретрофита:
   /* private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()*/
    private val retrofit = Retrofit.Builder()                           //1. нужен патерн Builder()
        .baseUrl(BASE_URL)                                              //2. передаем ссылку
        .addConverterFactory(MoshiConverterFactory.create(/*moshi*/))            //3. библиотека сериализатор - берет json и приобразует в какой-то объект
        .build()                                                        //4. вызываем метод, возвращающий инстанс ретрофита

    val searchApi: SearchApi = retrofit.create(SearchApi::class.java)     //создание ретрофита сервиса
}

interface SearchApi {                      //описываем сервис, работающий с url
    @Headers(
        "Accept: application/json",
        "Content-type: application/json"
    )
    @GET("/api")
    suspend fun getPerson(): PersonModel    //
}