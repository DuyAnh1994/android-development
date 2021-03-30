package com.dev.anhnd.android_list_demo.national

import com.dev.anhnd.mybase.utils.adapter.viewholder.ListItemListener


interface NationalListener : ListItemListener {
    fun onClickItem(position: Int, national: National)
    fun onLongClickItem(position: Int, national: National) = true
    fun onDeleteItem(position: Int, national: National) {}
}
