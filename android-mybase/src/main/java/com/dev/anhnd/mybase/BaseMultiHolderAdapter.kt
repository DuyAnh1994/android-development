package com.dev.anhnd.mybase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dev.anhnd.mybase.BaseMultiHolderAdapter.ModelType

abstract class BaseMultiHolderAdapter<T : ModelType>(
    @LayoutRes private val resLayout: List<Int>,
    diffUtil: BaseDiffCallback<T>
) : ListAdapter<T, BaseMultiHolderAdapter.BaseMultiViewHolder>(diffUtil) {

    companion object {
        const val VIEW_TYPE_DEFAULT = 0
    }

    /**
     * Listener action in item of list
     */
    var listener: ListItemListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseMultiViewHolder {
        return BaseMultiViewHolder(DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            resLayout[viewType],
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: BaseMultiViewHolder, position: Int) {
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

    override fun getItemViewType(position: Int) = getItem(position)?.viewType ?: VIEW_TYPE_DEFAULT

    override fun onViewAttachedToWindow(holderMulti: BaseMultiViewHolder) {
        super.onViewAttachedToWindow(holderMulti)
        holderMulti.clearAnimation()
    }

    class BaseMultiViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun clearAnimation() {
            binding.root.clearAnimation()
        }
    }

    /**
     * Must extend this class if use multi type view holder for list
     */
    abstract class ModelType(open val viewType: Int = VIEW_TYPE_DEFAULT)

    /**
     * All listener of adapter must implement this interface
     */
    interface ListItemListener
}
