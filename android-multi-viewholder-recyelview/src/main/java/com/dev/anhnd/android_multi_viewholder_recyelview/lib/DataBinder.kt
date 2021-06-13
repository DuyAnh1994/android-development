package com.dev.anhnd.android_multi_viewholder_recyelview.lib

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class DataBinder<T : RecyclerView.ViewHolder> {

    var dataBinderAdapter: DataBindAdapter? = null

    abstract fun newViewHolder(parent: ViewGroup): T

    abstract fun <T> bindViewHolder(holder: T, position: Int)

    abstract fun getItemCount(): Int
}
