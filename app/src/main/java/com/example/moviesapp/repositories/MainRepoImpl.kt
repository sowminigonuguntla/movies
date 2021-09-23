package com.example.moviesapp.repositories

import android.util.Log
import androidx.lifecycle.LiveData
//import com.example.moviesapp.MovieDao
import com.example.moviesapp.model.FavoriteMovieDataClass
import com.example.moviesapp.network.RestApiCollection
import com.example.moviesApp.model.MovieDetails

import com.example.moviesapp.model.MovieDataClass
//import com.example.moviesapp.network.RetrofitBuilder.API_KEY

class MainRepoImpl(private val apiService: RestApiCollection): MainRepo {

    override suspend fun getPopularMovies(): MovieDataClass? {

        return try{
            apiService.getMovies("01a677676e70dbdac873f2c58ab755de")
        } catch(e:Exception)
        {
            Log.e("Error",e.stackTraceToString())
            null
        }

    }

}