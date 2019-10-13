package com.example.mvp_movie_kotlin_app.networkUtils

import com.example.mvp_movie_kotlin_app.model.ResultMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie?")
    fun getMovieData(
        @Query("api_key")apiKey :String,
        @Query("language")language :String
    ):Call<ResultMovie>
}
