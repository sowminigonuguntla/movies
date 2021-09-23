package com.example.moviesapp.repositories

import androidx.lifecycle.LiveData
import com.example.moviesapp.db.MovieDao
import com.example.moviesapp.model.FavoriteMovieDataClass
import kotlinx.coroutines.flow.Flow

class FavouiteRepoImpl(private val dao: MovieDao): FavouriteRepo {
    override fun getFavMovieList(): Flow<List<FavoriteMovieDataClass>>{
        return dao.getMovies()
    }

    override suspend fun delete(favMovie: String) {
        dao.delete(favMovie)
    }


    override suspend fun insertFavMovie(favMovie: FavoriteMovieDataClass) {
        dao.insertMovie(favMovie)
    }

    override fun exists(Name: String): LiveData<Boolean> {
        return dao.exists(Name)
    }

    /*override suspend fun getFavMovie(movieId: Long): FavoriteMovieDataClass {
        return dao.getMovie(movieId)
    }*/

    override suspend fun delFavMovie(favMovie: FavoriteMovieDataClass) {
        dao.deleteMovie(favMovie)
    }
}