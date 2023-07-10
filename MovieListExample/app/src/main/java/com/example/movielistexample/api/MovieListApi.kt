package com.example.movielistexample.api

import com.example.movielistexample.models.MovieList
import com.example.movielistexample.models.PagedMovieList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MovieListApi {
    @Headers("X-API-Key: $api_key")                              //Загружаем список премьер
    @GET("/api/v2.2/films/premieres")
    suspend fun movie(@Query("year") year: Int, @Query("month") month: String): MovieList

    @Headers("X-API-Key: $api_key")                             //Загружаем список фильмоф ТОП из 250
    @GET("/api/v2.2/films/top?type=TOP_250_BEST-FILMS")
    suspend fun topList(@Query("page") page: Int): PagedMovieList

    private companion object{
        private const val api_key = "ce6f8lde-e-746-4a8b-8a79-4a7fe451b75d"
    }
}
val retrofit = Retrofit
    .Builder()
    .client(
        okHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().also{
            it.level = HttpLoggingInterceptor.Level.BODY
        }).build()
    )
    .baseUrl("https://kinopoiskapiunofficial.tech")
    .addConverterFactory(GsonConverterFactory.create())
    .create(MovieListApi::class.java)





























