package com.gokimpark.recommendmovie.android.librarydi.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.gokimpark.recommendmovie.android.librarydi.R

@BindingAdapter("app:imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    Glide.with(view)
        .load(imageUrl)
        .placeholder(R.drawable.image_loading)
        .into(view)
}