package com.dev.anhnd.mybase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.ListAdapter

abstract class BaseListAdapter<T : Any>(
    @LayoutRes private val resLayout: Int,
    diffUtil: BaseDiffCallback<T>
) : ListAdapter<T, BaseViewHolder>(diffUtil) {

    private lateinit var inflater: LayoutInflater

    /**
     * Listener action in item of list
     */
    var listener: BaseListItemListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        if (!::inflater.isInitialized) {
            inflater = LayoutInflater.from(parent.context)
        }
        val binding = DataBindingUtil.inflate<ViewDataBinding>(inflater, resLayout, parent, false)
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.binding.apply {
            /** ----- item of list ----- */
            setVariable(BR.item, getItem(holder.adapterPosition))
            /** ----- callback of view holder ----- */
            setVariable(BR.itemListener, listener)
            /** ----- position of item in list ----- */
            setVariable(BR.itemPosition, holder.adapterPosition)
            val context = holder.binding.root.context
            if (context is LifecycleOwner) {
                holder.binding.lifecycleOwner = context
            }
            executePendingBindings()
        }
    }

    override fun onViewDetachedFromWindow(holder: BaseViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.clearAnimation()
    }

    override fun onViewAttachedToWindow(holder: BaseViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.clearAnimation()
    }
}
