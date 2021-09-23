package com.example.moviesapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.model.MovieDataClass
//import com.example.moviesapp.model.MovieDataClass
import com.example.moviesapp.repositories.MainRepo
import com.example.moviesApp.model.MovieDetails
import kotlinx.coroutines.launch

class MainViewModel(private val repo: MainRepo): ViewModel() {
    private val _movies: MutableLiveData<MovieDataClass>? = MutableLiveData()
    val movies: LiveData<MovieDataClass>? = _movies

    init{
        viewModelScope.launch {
            _movies?.value = repo.getPopularMovies()
        }
    }

    /*fun getMoviesFromServer(){
        viewModelScope.launch{
            val movieList = repo.getMovies()

            _movies?.value = movieList
        }
    }*/
}