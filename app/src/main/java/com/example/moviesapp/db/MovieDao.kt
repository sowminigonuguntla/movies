package com.example.moviesapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.moviesapp.model.FavoriteMovieDataClass
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query ("SELECT * FROM favoritemoviedataclass" )
    fun getMovies(): Flow<List<FavoriteMovieDataClass>>

    /*@Query ("SELECT * FROM favoritemoviedataclass WHERE id=(:itemId)")
    suspend fun getMovie(itemId : Long): FavoriteMovieDataClass*/

    @Query("SELECT present FROM favoritemoviedataclass WHERE name=:name")
    fun exists(name: String): LiveData<Boolean>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movieModel: FavoriteMovieDataClass)

    @Delete
    suspend fun deleteMovie(movieModel: FavoriteMovieDataClass)

    @Query("DELETE FROM favoritemoviedataclass WHERE name = :name")
    suspend fun delete(name: String)
}

