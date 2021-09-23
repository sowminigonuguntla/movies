package com.example.moviesapp.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.adapters.FavouriteAdapter
import com.example.moviesapp.databinding.FragmentFavouritesBinding
import com.example.moviesapp.db.MovieDatabase
import com.example.moviesapp.repositories.FavouiteRepoImpl
import com.example.moviesapp.viewModels.FavouriteViewModel
import com.example.moviesapp.viewModels.FavouriteViewModelFactory


class FavouritesFragment : Fragment() {

    companion object{
        fun newInstance() = FavouritesFragment()
    }

    val database by lazy{MovieDatabase.getDatabase(context)}
    val repository by lazy{FavouiteRepoImpl(database.getMovieDao())}


    private lateinit var binding: FragmentFavouritesBinding
    private var adapter: FavouriteAdapter? = null
    private val favouriteViewModel: FavouriteViewModel by lazy {
        ViewModelProvider(this, FavouriteViewModelFactory(repository)).get(FavouriteViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_favourites, container, false)
        binding = FragmentFavouritesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FavouriteAdapter(emptyList())
        binding.rvFav.adapter = adapter
        binding.rvFav.layoutManager = GridLayoutManager(context,2)


        favouriteViewModel.favMovies!!.observe(viewLifecycleOwner,
            {favMovie ->
                favMovie.let {
                    adapter?.update(it!!)
                }
            }
            )
    }


}