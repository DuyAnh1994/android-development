package com.dev.anhnd.android_mvvm.model

import com.dev.anhnd.mybase.BaseMultiHolderAdapter.BaseMultiHolderModel


data class News(
    override val viewType: Int,
    val content: String = "default",
    val color: Int = -1,
    val image: Int = -1,
) : BaseMultiHolderModel(
    viewType = viewType
)
