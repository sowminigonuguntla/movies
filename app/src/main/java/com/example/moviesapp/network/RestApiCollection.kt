package com.example.moviesapp.network

import com.example.moviesapp.model.MovieDataClass
import com.example.moviesApp.model.MovieDetails
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApiCollection {
    @GET("/3/movie/popular")
    //suspend fun getMovies() : ArrayList<MovieDataClass>?
    suspend fun getMovies(@Query("api_key")key:String): MovieDataClass?
}