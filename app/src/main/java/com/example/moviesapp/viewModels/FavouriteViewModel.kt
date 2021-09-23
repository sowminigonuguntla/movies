package com.example.moviesapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.*
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.model.FavoriteMovieDataClass
import com.example.moviesapp.repositories.FavouriteRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class FavouriteViewModel(private val favRepo: FavouriteRepo): ViewModel() {
    //private val _favMovies: MutableLiveData<Flow<List<FavoriteMovieDataClass>>>? = MutableLiveData()
    //val favMovies: LiveData<Flow<List<FavoriteMovieDataClass>>>? = _favMovies

    val favMovies: LiveData<List<FavoriteMovieDataClass>> = favRepo.getFavMovieList().asLiveData()

    fun exists(name: String): LiveData<Boolean> {
        return favRepo.exists(name)
    }

    fun delete(name: String){
        viewModelScope.launch {
             favRepo.delete(name)
        }
    }

    /*init{
        viewModelScope.launch {
            _favMovies?.value = favRepo.getFavMovieList()
        }
    }*/

    /*fun getFavMovie(movieId: Long) {
        viewModelScope.launch {
            favRepo.getFavMovie(movieId)
        }
    }*/

    fun insertFavMovie(favMovie: FavoriteMovieDataClass) {
        viewModelScope.launch{
            favRepo.insertFavMovie(favMovie)
        }
    }

    fun delFavMovie(favMovie: FavoriteMovieDataClass){
        viewModelScope.launch {
            favRepo.delFavMovie(favMovie)
        }
    }
}