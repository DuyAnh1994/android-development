package com.dev.anhnd.android_note_todos.ui.home

import com.dev.anhnd.android_note_todos.R
import com.dev.anhnd.android_note_todos.data.model.Note
import com.dev.anhnd.mybase.utils.adapter.BaseAdapter
import com.dev.anhnd.mybase.utils.adapter.touch.ItemTouchSelect
import com.dev.anhnd.mybase.utils.adapter.touch.SelectedMode

@ItemTouchSelect(SelectedMode.MULTIPLE_SELECT)
class NoteAdapter : BaseAdapter<Note>(R.layout.item_note) {
}