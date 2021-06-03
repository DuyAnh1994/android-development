package com.dev.anhnd.android_motion

import com.dev.anhnd.android_coordinator.R
import com.dev.anhnd.mybase.utils.adapter.BaseAdapter
import com.dev.anhnd.mybase.utils.adapter.viewholder.ListItemListener

class FirstAdapter : BaseAdapter<First>(R.layout.item_first) {

}


interface FirstItemListener : ListItemListener {
    fun onClickItem(position: Int)
}