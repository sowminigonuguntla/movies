package com.example.moviesapp.repositories

import androidx.lifecycle.LiveData
import com.example.moviesapp.model.FavoriteMovieDataClass
import kotlinx.coroutines.flow.Flow

interface FavouriteRepo {
    suspend fun insertFavMovie(favMovie: FavoriteMovieDataClass)
    //suspend fun getFavMovie(movieId: Long) : FavoriteMovieDataClass
    fun exists(Name: String): LiveData<Boolean>
    fun getFavMovieList() : Flow<List<FavoriteMovieDataClass>>
    suspend fun delete(name: String)
    suspend fun delFavMovie(favMovie: FavoriteMovieDataClass)
}