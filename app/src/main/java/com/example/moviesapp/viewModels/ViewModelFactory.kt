package com.example.moviesapp.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapp.network.RetrofitBuilder
import com.example.moviesapp.repositories.MainRepoImpl
import java.lang.IllegalArgumentException

class ViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(MainRepoImpl(RetrofitBuilder.apiService)) as T
            }
        throw IllegalArgumentException("Unknown")
    }
}