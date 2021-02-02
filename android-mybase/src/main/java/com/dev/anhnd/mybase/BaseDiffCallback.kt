package com.dev.anhnd.mybase

import androidx.recyclerview.widget.DiffUtil

abstract class BaseDiffCallback<T : Any> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.javaClass.declaredFields.contentEquals(newItem.javaClass.declaredFields)
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.javaClass == newItem.javaClass
    }
}