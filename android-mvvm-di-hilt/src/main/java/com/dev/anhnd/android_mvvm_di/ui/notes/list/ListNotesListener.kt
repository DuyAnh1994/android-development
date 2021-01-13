package com.dev.anhnd.android_mvvm_di.ui.notes.list

import com.dev.anhnd.android_mvvm_di.data.local.notes.Notes
import com.dev.anhnd.mybase.BaseAdapter

interface ListNotesListener : BaseAdapter.ListItemListener {
    fun onClickItem(item: Notes, position:Int)
}