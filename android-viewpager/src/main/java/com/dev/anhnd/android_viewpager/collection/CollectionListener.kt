package com.dev.anhnd.android_viewpager.collection

import com.dev.anhnd.mybase.BaseListItemListener


interface CollectionListener : BaseListItemListener {
    fun onClickItem(position:Int)
}