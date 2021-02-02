package com.dev.anhnd.android_mvvm.ui.home

import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import com.dev.anhnd.mybase.BaseDiffCallback
import com.dev.anhnd.mybase.BaseMultiHolderAdapter

class NewsAdapter<T : BaseMultiHolderAdapter.ModelType>(
    @LayoutRes private val resLayout: List<Int>,
    diffUtil: BaseDiffCallback<T>
) : BaseMultiHolderAdapter<T>(resLayout, diffUtil) {

    companion object {
        const val VIEW_TYPE_TEXT = 0
        const val VIEW_TYPE_COLOR = 1
        const val VIEW_TYPE_IMAGE = 2
    }
}
