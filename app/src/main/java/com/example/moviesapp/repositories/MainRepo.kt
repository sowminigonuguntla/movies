package com.example.moviesapp.repositories

import androidx.lifecycle.LiveData
import com.example.moviesapp.model.FavoriteMovieDataClass
import com.example.moviesapp.model.MovieDataClass


interface MainRepo {
    suspend fun getPopularMovies() : MovieDataClass?

}