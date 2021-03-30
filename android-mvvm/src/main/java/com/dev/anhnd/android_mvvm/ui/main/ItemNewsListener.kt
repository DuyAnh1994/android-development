package com.dev.anhnd.android_mvvm.ui.main

import android.view.View
import com.dev.anhnd.mybase.utils.adapter.BaseMultiHolderAdapter
import com.dev.anhnd.mybase.utils.adapter.viewholder.ListItemListener

interface ItemNewsListener: ListItemListener {
    fun onItemClick(v: View, item: BaseMultiHolderAdapter.BaseModelType, position:Int)
}