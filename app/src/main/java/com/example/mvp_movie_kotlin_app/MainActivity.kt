package com.example.mvp_movie_kotlin_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mvp_movie_kotlin_app.adapter.MovieAdapter
import com.example.mvp_movie_kotlin_app.model.ResultsItem
import com.example.mvp_movie_kotlin_app.presenter.MoviePresenter
import com.example.mvp_movie_kotlin_app.presenter.MovieView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MovieView {

    override fun onSuccessMovie(data: List<ResultsItem?>?) {
        rv_movie.adapter = MovieAdapter(data)

    }

    override fun onErrorMovie(msg: String) {
        Log.d("ERROR",msg?:"")
    }

    private lateinit var presenter: MoviePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MoviePresenter(this)
        presenter.getDataMovie()
    }
}
