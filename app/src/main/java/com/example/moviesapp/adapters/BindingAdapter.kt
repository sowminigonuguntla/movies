package com.example.moviesapp.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("image")


fun ImageView.setImage(image: String?) {

    Glide.with(context)

        .load("https://image.tmdb.org/t/p/w500${image}")
        .into(this)

}