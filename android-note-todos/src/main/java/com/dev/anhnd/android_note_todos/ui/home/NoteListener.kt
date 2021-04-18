package com.dev.anhnd.android_note_todos.ui.home

import com.dev.anhnd.android_note_todos.data.model.Note
import com.dev.anhnd.mybase.utils.adapter.viewholder.ListItemListener

interface NoteListener : ListItemListener {

    fun onClickItem(position : Int, item: Note)

    fun onLongClickItem(position: Int, item: Note)
}