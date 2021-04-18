package com.dev.anhnd.android_nested_recycleview.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.dev.anhnd.android_nested_recycleview.model.Continents
import com.dev.anhnd.android_nested_recycleview.ui.nation.NationAdapter
import com.dev.anhnd.android_nested_recycleview.R
import com.dev.anhnd.android_nested_recycleview.databinding.ItemContinentsBinding
import com.dev.anhnd.mybase.utils.adapter.BaseAdapter
import com.dev.anhnd.mybase.utils.adapter.viewholder.BaseViewHolder

class ContinentsAdapter : BaseAdapter<Continents>(R.layout.item_continents) {

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        (holder.binding as ItemContinentsBinding).let { binding ->
            val adapter = NationAdapter().apply {
                listener = this@ContinentsAdapter.listener
            }
            adapter.submitList(data?.get(position)?.nations)
            binding.adapter = adapter
        }
        super.onBindViewHolder(holder, position)
    }
}
