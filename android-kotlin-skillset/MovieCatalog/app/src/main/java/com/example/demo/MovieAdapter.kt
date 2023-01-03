package com.example.demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demo.models.Movie

class MovieAdapter( private val movies : List<Movie> ) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindMovie(movie : Movie) {

            var movieTitle: TextView = itemView.findViewById(R.id.movie_title)
            val movieReleaseDate: TextView = itemView.findViewById(R.id.movie_release_date)

            movieTitle.text = movie.title
            movieReleaseDate.text = movie.release

            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.findViewById(R.id.movie_poster))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder (
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies[position])
    }
}