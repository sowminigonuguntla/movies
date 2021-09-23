package com.example.moviesapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapp.repositories.FavouriteRepo

class FavouriteViewModelFactory(private val repo: FavouriteRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavouriteViewModel::class.java)) {
            return FavouriteViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown Class")
    }
}