package com.dev.anhnd.mybase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView

open class BaseAdapter<T : Any>(
    @LayoutRes private val resLayout: Int
) : RecyclerView.Adapter<BaseViewHolder>() {

    private lateinit var inflater: LayoutInflater

    /**
     * List item
     */
    var data: List<T>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

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
        val item = data?.get(holder.adapterPosition)
        /** ----- item of list ----- */
        holder.binding.setVariable(BR.item, item)
        /** ----- callback of view holder ----- */
        holder.binding.setVariable(BR.itemListener, listener)
        /** ----- position of item in list ----- */
        holder.binding.setVariable(BR.itemPosition, holder.adapterPosition)
        val context = holder.binding.root.context
        if (context is LifecycleOwner) {
            holder.binding.lifecycleOwner = context
        }
        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = data?.size ?: 0
}
