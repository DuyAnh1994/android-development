package com.dev.anhnd.android_viewpager.collection

import com.dev.anhnd.mybase.BaseAdapter


interface CollectionListener : BaseAdapter.ListItemListener {
    fun onClickItem(position:Int)
}