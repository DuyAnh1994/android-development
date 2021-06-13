package com.dev.anhnd.android_multi_viewholder_recyelview.app.binder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dev.anhnd.android_multi_viewholder_recyelview.BR
import com.dev.anhnd.android_multi_viewholder_recyelview.R
import com.dev.anhnd.android_multi_viewholder_recyelview.app.model.News
import com.dev.anhnd.android_multi_viewholder_recyelview.databinding.ItemNewsBinding
import com.dev.anhnd.android_multi_viewholder_recyelview.lib.DataBindAdapter
import com.dev.anhnd.android_multi_viewholder_recyelview.lib.DataBinder

class NewsBinder(private val adapter: DataBindAdapter) : DataBinder<NewsBinder.NewsViewHolder>() {

    var data: List<News>? = null
        set(value) {
            field = value
            adapter.notifyDataSetChanged()
        }

    override fun newViewHolder(parent: ViewGroup): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemNewsBinding>(inflater, R.layout.item_news, parent, false)
        return NewsViewHolder(binding)
    }

    override fun <T> bindViewHolder(holder: T, position: Int) {
        (holder as NewsViewHolder).apply {
            binding.setVariable(BR.item, data?.get(position))
        }
    }

    override fun getItemCount() = data?.size ?: 0

    class NewsViewHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root)
}
