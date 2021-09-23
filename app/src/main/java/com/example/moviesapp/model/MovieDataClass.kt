package com.example.moviesapp.model

import androidx.annotation.Keep
import com.example.moviesApp.model.MovieDetails
import com.google.gson.annotations.SerializedName

@Keep
data class MovieDataClass(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<MovieDetails>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?


)