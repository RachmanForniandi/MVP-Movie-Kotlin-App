package com.example.mvp_movie_kotlin_app.networkUtils

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig {

    fun getInterceptor() : OkHttpClient{

        val interceptor = HttpLoggingInterceptor()

        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
            .build()
    }

    fun obtainRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/discover/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    fun service() = obtainRetrofit().create(MovieService::class.java)
}