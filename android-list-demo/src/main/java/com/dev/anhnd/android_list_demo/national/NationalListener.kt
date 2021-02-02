package com.dev.anhnd.android_list_demo.national

import com.dev.anhnd.mybase.BaseListItemListener


interface NationalListener : BaseListItemListener {
    fun onClickItem(position: Int, national: National)
    fun onLongClickItem(position: Int, national: National) = true
}
