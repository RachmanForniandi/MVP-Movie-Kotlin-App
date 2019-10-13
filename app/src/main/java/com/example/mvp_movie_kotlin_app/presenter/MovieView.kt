package com.example.mvp_movie_kotlin_app.presenter

import com.example.mvp_movie_kotlin_app.model.ResultsItem

interface MovieView {

    fun onSuccessMovie(data : List<ResultsItem?>?)
    fun onErrorMovie(msg : String)
}