package com.dev.anhnd.android_mvvm.model

import com.dev.anhnd.android_mvvm.ui.home.NewsAdapter
import com.dev.anhnd.mybase.BaseMultiHolderAdapter.ModelType


data class News(
    override val viewType: Int,
    val content: String = "default",
    val color: Int = -1,
    val image: Int = -1,
) : ModelType(
    viewType = viewType
)


data class Text(val text: String = "") : ModelType(viewType = NewsAdapter.VIEW_TYPE_TEXT)
data class Color(val color: Int = -1) : ModelType(viewType = NewsAdapter.VIEW_TYPE_COLOR)
data class Image(val image: Int = -1, val url : String="") : ModelType(viewType = NewsAdapter.VIEW_TYPE_IMAGE)
