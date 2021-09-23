package com.example.moviesapp.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesapp.viewModels.MainViewModel
import com.example.moviesapp.adapters.MyAdapter
import com.example.moviesapp.databinding.FragmentHomeBinding
import com.example.moviesapp.viewModels.ViewModelFactory
import com.example.moviesApp.model.MovieDetails
import com.example.moviesapp.views.ItemClickListener

//import kotlinx.android.synthetic.main.recycler_file.*

class HomeFragment : Fragment(), ItemClickListener {

    companion object{
        fun newInstance() = HomeFragment()
    }

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: MainViewModel by lazy{
        ViewModelProvider(this, ViewModelFactory()).get(MainViewModel::class.java)
    }
    private var myAdapter: MyAdapter?= null




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myAdapter = MyAdapter(emptyList(),this)
        binding.moviesRecyclerView.adapter = myAdapter
        binding.moviesRecyclerView.layoutManager= GridLayoutManager(requireContext(),3)

        viewModel.movies!!.observe(viewLifecycleOwner,
            { movie->
            movie.let{ list->
                myAdapter?.updateList(list.results!!) }
        })
    }

    override fun onClick(position: Int, details: MovieDetails) {
        val action = HomeFragmentDirections
            .actionHomeFragmentToMovieOverViewFragment(
                details.title!!,
                details.backdropPath!!,
                details.overview!!,
                details.adult.toString()!!,
                details.releaseDate!!,
                details.voteAverage?.toFloat()!!,
                details.originalLanguage!!


            )
        findNavController().navigate(action)
    }


    /*private fun setUpView(){
        viewModel.getMoviesFromServer()

        movies_recycler_view.adapter = myAdapter
        movies_recycler_view.layoutManager = LinearLayoutManager(requireContext())

    }

    private fun setUpViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory()).get(MainViewModel::class.java)
    }*/

    /*private fun changeFavoriteIconColorToRed() {
        favorite_image_button.setColorFilter(
            ContextCompat.getColor(this@HomeFragment, R.color.favorite),
            android.graphics.PorterDuff.Mode.SRC_IN)
    }

    private fun changeFavoriteIconColorToGrey() {
        favorite_image_button.setColorFilter(
            ContextCompat.getColor(this@HomeFragment, R.color.unFavorite),
            android.graphics.PorterDuff.Mode.SRC_IN)
    }*/
}