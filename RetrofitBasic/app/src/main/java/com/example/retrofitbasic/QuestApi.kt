package com.example.retrofitbasic

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface QuestApi {


        @GET("./getQuestList")
        @Headers("Content-Type: application/json")
        fun getQuestList(): Single<QuestListResponse>

}