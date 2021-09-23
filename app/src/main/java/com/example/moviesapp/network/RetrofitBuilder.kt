package com.example.moviesapp.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {

        private const val BASE_URL = "https://api.themoviedb.org"
        //const val API_KEY = "01a677676e70dbdac873f2c58ab755de"

        private fun getRetrofit() : Retrofit {
            return Retrofit.Builder()
                .client(provideOkHttpClient())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private fun provideOkHttpClient(): OkHttpClient {

            return OkHttpClient().newBuilder()

                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS).build()
        }

        val apiService: RestApiCollection = getRetrofit().create(RestApiCollection::class.java)

    }
