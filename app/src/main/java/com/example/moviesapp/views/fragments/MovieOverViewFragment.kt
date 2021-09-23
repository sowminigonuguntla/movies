package com.example.moviesapp.views.fragments

import android.R.attr
import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
//import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.databinding.FragmentMovieOverViewBinding
import com.example.moviesapp.db.MovieDatabase
import com.example.moviesapp.model.FavoriteMovieDataClass
import com.example.moviesapp.repositories.FavouiteRepoImpl
import com.example.moviesapp.viewModels.FavouriteViewModel
import com.example.moviesapp.viewModels.FavouriteViewModelFactory
import kotlinx.android.synthetic.main.fragment_movie_over_view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import android.graphics.Color

import android.R.attr.button

import android.view.MotionEvent
import android.view.View.OnTouchListener


class MovieOverViewFragment : Fragment() {

    private lateinit var binding: FragmentMovieOverViewBinding
    //var boolean: Boolean = clicked()
    //lateinit var sharedPreferences: SharedPreferences

    val args: MovieOverViewFragmentArgs by navArgs()
    val database by lazy { MovieDatabase.getDatabase(context) }
    val repository by lazy { FavouiteRepoImpl(database.getMovieDao()) }
    private val movieViewModel: FavouriteViewModel by lazy {
        ViewModelProvider(this,
            FavouriteViewModelFactory(repository)).get(FavouriteViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_movie_over_view, container, false)
        binding = FragmentMovieOverViewBinding.inflate(inflater, container, false)
        return binding.root

        //favorite_image_button.setOnClickListener{onFavoriteIconClicked()}
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.O)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movieTitle = args.movieTitle
        binding.txtItemTitle.text = movieTitle


        val movieBackdrop = args.moviePoster
        val url = "https://image.tmdb.org/t/p/w500${movieBackdrop}"
        Glide.with(view.context)
            .load(url)
            .into(binding.imgItemPoster)

        val description = args.description
        binding.txtitemDescription.text = description

        val adultRated = args.adult
        binding.txtItemAdult.visibility = if (adultRated == "true") {
            View.VISIBLE
        } else View.GONE

        val releaseDate = LocalDate.parse(args.releaseyear, DateTimeFormatter.ISO_DATE)
        binding.txtItemReleaseDate.text = releaseDate.toString()

        binding.txtItemRating.text = args.rating.toString()

        val originalLang = args.originalLanguage
        binding.originalLanguage.text = originalLang

        //val exists = movieViewModel.exists(movieTitle)

        movieViewModel.exists(movieTitle)!!.observe(viewLifecycleOwner,
            { favMovie ->
                if (favMovie == true) {
                    binding.favouriteImageButton.isChecked = true

                }
                binding.favouriteImageButton.setOnCheckedChangeListener {_, isChecked->

                    if(isChecked){
                        Toast.makeText(context, "Added to favorites", Toast.LENGTH_SHORT).show()

                        movieViewModel.insertFavMovie(
                            FavoriteMovieDataClass(
                                name = movieTitle,
                                posterPath = movieBackdrop,
                                present = true
                            )
                        )

                    } else {
                        Toast.makeText(context, "Removed from favorites", Toast.LENGTH_SHORT).show()
                        movieViewModel.delete(movieTitle)
                            //FavoriteMovieDataClass(
                                //name = movieTitle,
                                //posterPath = movieBackdrop,
                                //present = false

                    }

                }


    }
        )

    }
        }








    /*private fun onFavoriteIconClicked() {
        scope.launch {
            val favoriteMovie : FavoriteMovieDataClass = movieViewModel.getFavMovie(movieId = 550)

            if (favoriteMovie != null)
            { removeMovieFromDbAndHintUser(favoriteMovie) }

            else{ insertFavMovie() }
        }
    }

    private suspend fun removeMovieFromDbAndHintUser(favoriteMovie: FavoriteMovieDataClass) {
        movieViewModel.delFavMovie(favoriteMovie)
        favorite_image_button.setColorFilter(
            ContextCompat.getColor(Context, R.color.unFavorite),
            android.graphics.PorterDuff.Mode.SRC_IN)
        Toast.makeText(this, "Removed from favorites.", Toast.LENGTH_SHORT).show()
    }*/



