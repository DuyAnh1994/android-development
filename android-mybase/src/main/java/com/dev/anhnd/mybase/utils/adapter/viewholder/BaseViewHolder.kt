package com.dev.anhnd.mybase.utils.adapter.viewholder

import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.dev.anhnd.mybase.R
import com.dev.anhnd.mybase.utils.adapter.touch.Extension
import com.dev.anhnd.mybase.utils.adapter.touch.ItemTouchSwipe

open class BaseViewHolder(val binding: ViewDataBinding,
                          private val annotationSwipe: ItemTouchSwipe?
) : RecyclerView.ViewHolder(binding.root), Extension {

    fun getLayoutMenu(): ViewGroup {
        val id = annotationSwipe?.let {
            if (it.menuId == View.NO_ID) {
                R.id.item_menu
            } else {
                it.menuId
            }
        } ?: run {
            View.NO_ID
        }
        return binding.root.findViewById(id)
    }

    fun getLayoutContent(): ViewGroup {
        val id = annotationSwipe?.let {
            if (it.contentId == View.NO_ID) {
                R.id.item_content
            } else {
                it.contentId
            }
        } ?: run {
            View.NO_ID
        }
        return binding.root.findViewById(id)
    }

    override fun getActionWidth(): Float {
        return getLayoutMenu().width.toFloat()
    }
}
