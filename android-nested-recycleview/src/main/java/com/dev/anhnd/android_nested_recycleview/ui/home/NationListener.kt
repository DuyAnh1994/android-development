package com.dev.anhnd.android_nested_recycleview.ui.home

import com.dev.anhnd.android_nested_recycleview.model.Nation
import com.dev.anhnd.mybase.utils.adapter.viewholder.ListItemListener

interface NationListener : ListItemListener {
    fun onNation(childPosition: Int, nation: Nation)
}