package com.example.moviesapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviesapp.model.FavoriteMovieDataClass

@Database (entities = [FavoriteMovieDataClass::class], version = 1, exportSchema = false )
abstract class MovieDatabase : RoomDatabase() {
    abstract fun getMovieDao(): MovieDao

    companion object{

        @Volatile
        private var INSTANCE: MovieDatabase?= null

        fun getDatabase(context: Context?): MovieDatabase{

            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context!!.applicationContext,
                    MovieDatabase::class.java,
                    "fav_movies_db"
                ).build()
                INSTANCE = instance

                instance
            }
        }

    }
}