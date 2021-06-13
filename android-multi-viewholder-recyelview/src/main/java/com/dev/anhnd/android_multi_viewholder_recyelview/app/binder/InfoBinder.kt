package com.dev.anhnd.android_multi_viewholder_recyelview.app.binder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dev.anhnd.android_multi_viewholder_recyelview.BR
import com.dev.anhnd.android_multi_viewholder_recyelview.R
import com.dev.anhnd.android_multi_viewholder_recyelview.app.model.Info
import com.dev.anhnd.android_multi_viewholder_recyelview.databinding.ItemInfoBinding
import com.dev.anhnd.android_multi_viewholder_recyelview.lib.DataBindAdapter
import com.dev.anhnd.android_multi_viewholder_recyelview.lib.DataBinder

class InfoBinder(private val adapter: DataBindAdapter) : DataBinder<InfoBinder.InfoViewHolder>() {

    var data: Info? = null
        set(value) {
            field = value
            adapter.notifyDataSetChanged()
        }

    override fun newViewHolder(parent: ViewGroup): InfoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemInfoBinding>(inflater, R.layout.item_info, parent, false)
        return InfoViewHolder(binding)
    }

    override fun <T> bindViewHolder(holder: T, position: Int) {
        (holder as InfoViewHolder).apply {
            binding.setVariable(BR.item, data)
        }
    }

    override fun getItemCount() = 1

    class InfoViewHolder(val binding: ItemInfoBinding) : RecyclerView.ViewHolder(binding.root)
}
