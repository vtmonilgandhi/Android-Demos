package com.example.demo.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieGenre(
    @SerializedName("id")
    val id : String ?,

    @SerializedName("name")
    val name : String?,

) : Parcelable {
    constructor() : this("", "")
}