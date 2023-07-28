package com.example.retrofitbasic

import io.reactivex.Single
import retrofit2.http.GET

interface QuestApi {


        @GET("./getQuestList")
        fun getQuestList(): Single<QuestListResponse>

}