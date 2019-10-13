package com.example.mvp_movie_kotlin_app.presenter

import com.example.mvp_movie_kotlin_app.model.ResultMovie
import com.example.mvp_movie_kotlin_app.networkUtils.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviePresenter (val movieView: MovieView){

    fun getDataMovie(){
        NetworkConfig.service().getMovieData("04a5984bb20ef987a182de11ee3810b4","en-US")
            .enqueue(object : Callback<ResultMovie> {
                override fun onFailure(call: Call<ResultMovie>, t: Throwable) {
                    movieView.onErrorMovie(t.localizedMessage)

                }

                override fun onResponse(call: Call<ResultMovie>, response: Response<ResultMovie>) {
                    if (response.isSuccessful){
                        movieView.onSuccessMovie(response.body()?.results)
                    }
                }
            })
    }
}