package com.dev.anhnd.android_multi_viewholder_recyelview.app

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("iv_set_image")
fun ImageView.setImage(src: Int) {
    setImageResource(src)
}