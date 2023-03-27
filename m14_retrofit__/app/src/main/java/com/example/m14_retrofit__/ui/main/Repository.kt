package com.example.m14_retrofit__.ui.main

class Repository {

    suspend fun getData(): PersonModel{
        return RetrofitServices.searchApi.getPerson()
    }
}