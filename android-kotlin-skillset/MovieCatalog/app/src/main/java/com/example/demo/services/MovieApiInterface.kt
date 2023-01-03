package com.example.demo.services

import com.example.demo.models.MovieGenreResponse
import com.example.demo.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("/3/movie/popular?api_key=bbf5a3000e95f1dddf266b5e187d4b21")
    fun getMovieList(): Call<MovieResponse>

    @GET("https://api.themoviedb.org/3/genre/movie/list?api_key=bbf5a3000e95f1dddf266b5e187d4b21&language=en-US")
    fun getMovieGenreList(): Call<MovieGenreResponse>
}