package com.example.demo.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    @SerializedName("results")
    val movies : List<Movie>

) : Parcelable {
    constructor() : this(mutableListOf())
}

@Parcelize
data class MovieGenreResponse(
    @SerializedName("genres")
    val genres : List<MovieGenre>

) : Parcelable {
    constructor() : this(mutableListOf())
}