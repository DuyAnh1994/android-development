package com.dev.anhnd.mybase

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    fun clearAnimation() {
        binding.root.clearAnimation()
    }
}