package com.dev.anhnd.android_motion

import com.dev.anhnd.android_coordinator.R
import com.dev.anhnd.mybase.utils.adapter.BaseAdapter
import com.dev.anhnd.mybase.utils.adapter.viewholder.ListItemListener

class SecondAdapter : BaseAdapter<Second>(R.layout.item_second) {

}

interface SecondItemListener : ListItemListener {
    fun onClickItem(position: Int)
}