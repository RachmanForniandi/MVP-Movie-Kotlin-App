package com.example.mvp_movie_kotlin_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.mvp_movie_kotlin_app.model.ResultsItem
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_movie.view.*

class DetailActivity : AppCompatActivity() {

    private lateinit var movie:ResultsItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        movie = intent.getParcelableExtra("movie") as ResultsItem

        txt_detail_title.text = movie.title
        txt_detail_release_date.text = movie.releaseDate
        txt_description.text = movie.overview

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w185"+movie.posterPath)
            .into(img_detail_photo)
    }
}
