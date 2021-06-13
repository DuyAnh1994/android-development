package com.dev.anhnd.android_multi_viewholder_recyelview.lib

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class DataBindAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val dataBinder = (getDataBinder(viewType) as DataBinder<*>)
        return dataBinder.newViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binderPosition = getBinderPosition(position)
        val dataBinder = getDataBinder(holder.itemViewType) as DataBinder<*>
        dataBinder.bindViewHolder(holder, binderPosition)
    }

    abstract override fun getItemCount(): Int

    abstract override fun getItemViewType(position: Int): Int

    abstract fun <T : DataBinder<*>> getDataBinder(viewType: Int): T

    abstract fun getPosition(binder: DataBinder<*>, binderPosition: Int): Int

    abstract fun getBinderPosition(position: Int): Int
}
