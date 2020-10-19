package com.dev.anhnd.mybase.utils.app

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.dev.anhnd.mybase.R
import com.dev.anhnd.mybase.utils.options

@BindingAdapter("ivLoadImageByUrl")
fun ImageView.loadBackgroundByUrl(url: String) {
    Glide.with(this)
        .load(url)
        .error(R.drawable.default_photo)
        .apply(options.skipMemoryCache(true))
        .centerCrop()
        .into(this)
}

@BindingAdapter("ivLoadImageByUri")
fun ImageView.loadBackgroundByUrl(uri: Uri) {
    Glide.with(this)
        .load(uri)
        .apply(options.skipMemoryCache(true))
        .centerCrop()
        .into(this)
}


