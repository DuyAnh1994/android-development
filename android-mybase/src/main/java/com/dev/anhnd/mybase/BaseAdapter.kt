package com.dev.anhnd.mybase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T : Any>(
    @LayoutRes private val resLayout: Int,
    diffUtil: BaseDiffCallback<T>
) : ListAdapter<T, BaseAdapter.BaseViewHolder>(diffUtil) {

    /**
     * Listener action in item of list
     */
    var listener: ListItemListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            resLayout,
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.binding.apply {
            /** ----- item of list ----- */
            setVariable(BR.item, getItem(position))
            /** ----- callback of view holder ----- */
            setVariable(BR.itemListener, listener)
            /** ----- position of item in list ----- */
            setVariable(BR.itemPosition, holder.adapterPosition)
            executePendingBindings()
        }
    }

    override fun onViewDetachedFromWindow(holder: BaseViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.clearAnimation()
    }

    class BaseViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun clearAnimation() {
            binding.root.clearAnimation()
        }
    }

    override fun onViewAttachedToWindow(holder: BaseViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.clearAnimation()
    }

    /**
     * All listener of adapter must implement this interface
     */
    interface ListItemListener
}


