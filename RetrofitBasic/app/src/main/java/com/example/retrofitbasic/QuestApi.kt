package com.example.retrofitbasic

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface QuestApi {


        @GET("./getQuestList")
        @Headers("Content-Type: application/json")
        fun getQuestList(): Single<QuestListResponse>

        @GET("/getQuest/{questId}")      // точку не использовать
        @Headers("Content-Type: application/json")
        fun getQuest(@Path ("questId") questId : String):Single<String>
















}