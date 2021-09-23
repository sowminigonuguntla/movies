package com.example.moviesapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.databinding.FavMovieItemBinding
import com.example.moviesapp.model.FavoriteMovieDataClass
import kotlinx.coroutines.flow.Flow

class FavouriteAdapter(private var favouriteMovies: List<FavoriteMovieDataClass>):
    RecyclerView.Adapter<FavouriteAdapter.FavViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FavMovieItemBinding.inflate(inflater,parent,false)
        return FavViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavViewHolder, position: Int) {
        with(holder) {
            with(favouriteMovies[position]) {
                binding.txtFavMovieTitle.text = this.name
                com.bumptech.glide.Glide.with(holder.itemView.context)
                    .load("https://image.tmdb.org/t/p/w500${this.posterPath}")
                    .into(binding.imgFavItemPoster)
                }
            }
        }


    override fun getItemCount(): Int {
        return favouriteMovies.size
    }

    inner class FavViewHolder(val binding: FavMovieItemBinding): RecyclerView.ViewHolder(binding.root)

    fun update(list: List<FavoriteMovieDataClass>){
        this.favouriteMovies = list
        notifyDataSetChanged()
    }

}