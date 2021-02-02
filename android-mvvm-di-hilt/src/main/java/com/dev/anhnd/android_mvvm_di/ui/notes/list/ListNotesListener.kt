package com.dev.anhnd.android_mvvm_di.ui.notes.list

import com.dev.anhnd.android_mvvm_di.data.local.notes.Notes
import com.dev.anhnd.mybase.BaseListItemListener

interface ListNotesListener : BaseListItemListener {
    fun onClickItem(position: Int, item: Notes)
    fun onLongClickItem(position: Int, item: Notes) = true
}