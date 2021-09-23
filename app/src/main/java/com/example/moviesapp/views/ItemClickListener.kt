package com.example.moviesapp.views

import com.example.moviesApp.model.MovieDetails

interface ItemClickListener {

    fun onClick(position: Int, result: MovieDetails)
}