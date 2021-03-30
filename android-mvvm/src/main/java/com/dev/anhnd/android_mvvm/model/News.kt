package com.dev.anhnd.android_mvvm.model

import com.dev.anhnd.android_mvvm.ui.home.NewsAdapter
import com.dev.anhnd.mybase.utils.adapter.BaseMultiHolderAdapter.BaseModelType


data class News(
    override val viewType: Int,
    val content: String = "default",
    val color: Int = -1,
    val image: Int = -1,
) : BaseModelType(
    viewType = viewType
)


data class Text(val text: String = "") : BaseModelType(viewType = NewsAdapter.VIEW_TYPE_TEXT)
data class Color(val color: Int = -1) : BaseModelType(viewType = NewsAdapter.VIEW_TYPE_COLOR)
data class Image(val image: Int = -1, val url : String="") : BaseModelType(viewType = NewsAdapter.VIEW_TYPE_IMAGE)
