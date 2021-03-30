package com.dev.anhnd.android_mvvm.ui.home

import com.dev.anhnd.android_mvvm.R
import com.dev.anhnd.mybase.utils.adapter.BaseMultiHolderAdapter
import com.dev.anhnd.mybase.utils.adapter.touch.ItemTouchDrag

val resLayouts = listOf(
    R.layout.item_first,
    R.layout.item_second,
    R.layout.item_third
)

@ItemTouchDrag
class NewsAdapter : BaseMultiHolderAdapter<BaseMultiHolderAdapter.BaseModelType>(resLayouts) {

    companion object {
        const val VIEW_TYPE_TEXT = 0
        const val VIEW_TYPE_COLOR = 1
        const val VIEW_TYPE_IMAGE = 2
    }
}

