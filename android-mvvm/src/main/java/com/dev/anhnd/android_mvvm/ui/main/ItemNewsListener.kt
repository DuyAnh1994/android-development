package com.dev.anhnd.android_mvvm.ui.main

import android.view.View
import com.dev.anhnd.android_mvvm.model.News
import com.dev.anhnd.mybase.BaseMultiHolderAdapter

interface ItemNewsListener: BaseMultiHolderAdapter.ListItemListener {
    fun onItemClick(v: View, item: BaseMultiHolderAdapter.ModelType, position:Int)
}