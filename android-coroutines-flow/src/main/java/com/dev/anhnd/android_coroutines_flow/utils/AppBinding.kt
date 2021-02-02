package com.dev.anhnd.android_coroutines_flow.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("tv_set_strike")
fun TextView.setStrike(v: Boolean) {
    paint.isStrikeThruText = v
}