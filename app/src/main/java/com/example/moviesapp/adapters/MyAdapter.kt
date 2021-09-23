package com.example.moviesapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesApp.model.MovieDetails
import com.example.moviesapp.databinding.MovieListBinding
import com.example.moviesapp.views.ItemClickListener
import com.example.moviesapp.views.fragments.HomeFragment
//import com.example.moviesapp.databinding.RecyclerFileBinding
import com.example.moviesapp.model.MovieDataClass
//import com.example.MoviesApp.model.MovieDetails


class MyAdapter(private var popularmovies: List<MovieDetails>, val listener: ItemClickListener): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = MovieListBinding.inflate(inflater,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        with(holder) {
            with(popularmovies[position]) {
                /*binding.txtMovieTitle.text = this.title
                Glide.with(holder.itemView.context)
                    .load("https://image.tmdb.org/t/p/w500${this.posterPath}")
                    .into(binding.imgPoster)*/

                holder.itemView.setOnClickListener() {
                    listener.onClick(adapterPosition, this)



                }

                binding.user = popularmovies[position]
            }
        }

        //holder.binding.user = popularmovies[position]


    }

    override fun getItemCount(): Int {
        return popularmovies.size
    }

    fun updateList(movies: List<MovieDetails>){
        this.popularmovies = movies
        notifyDataSetChanged()
    }

   inner class MyViewHolder(val binding: MovieListBinding): RecyclerView.ViewHolder(binding.root){

    }

}

