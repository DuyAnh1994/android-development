package com.dev.anhnd.android_viewpager.collection

import com.dev.anhnd.mybase.utils.adapter.viewholder.ListItemListener


interface CollectionListener : ListItemListener {
    fun onClickItem(position:Int)
}