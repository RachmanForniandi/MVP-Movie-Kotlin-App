package com.example.mvp_movie_kotlin_app.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvp_movie_kotlin_app.DetailActivity
import com.example.mvp_movie_kotlin_app.R
import com.example.mvp_movie_kotlin_app.model.ResultsItem
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter (var data: List<ResultsItem?>?): RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false)
        return MovieHolder(view)
    }

    override fun getItemCount()= data?.size ?:0

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(data?.get(position))

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,DetailActivity::class.java)
            intent.putExtra("movie",data?.get(position))
            holder.itemView.context.startActivity(intent)
        }
    }

    class MovieHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

        fun bind(get: ResultsItem?){
            itemView.tv_title_movie.text = get?.title
            itemView.tv_desc_movie.text = get?.overview

            Glide.with(itemView.context)
                .load("https://image.tmdb.org/t/p/w185"+get?.posterPath)
                .into(itemView.img_movie)
        }
    }
}