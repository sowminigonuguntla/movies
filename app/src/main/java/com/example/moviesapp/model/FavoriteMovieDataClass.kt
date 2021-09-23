package com.example.moviesapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteMovieDataClass(@PrimaryKey(autoGenerate = true)
                                  val id: Int=0,
                                  val posterPath: String,
                                  val name: String,
                                  val present: Boolean){

}
