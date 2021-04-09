package com.dev.anhnd.android_mvvm_di_hilt.ui.notes.list

import com.dev.anhnd.android_mvvm_di_hilt.data.source.local.entity.Notes
import com.dev.anhnd.mybase.utils.adapter.viewholder.ListItemListener

interface ListNotesListener : ListItemListener {
    fun onClickItem(position: Int, item: Notes)
    fun onLongClickItem(position: Int, item: Notes) = true
}