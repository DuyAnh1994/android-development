package com.dev.anhnd.android_mvvm_di_hilt.ui.notes.list

import com.dev.anhnd.android_mvvm_di_hilt.R
import com.dev.anhnd.android_mvvm_di_hilt.data.source.local.entity.Notes
import com.dev.anhnd.mybase.utils.adapter.BaseAdapter
import com.dev.anhnd.mybase.utils.adapter.touch.ItemTouchSelect
import com.dev.anhnd.mybase.utils.adapter.touch.ItemTouchSwipe
import com.dev.anhnd.mybase.utils.adapter.touch.SelectedMode

@ItemTouchSelect(mode = SelectedMode.MULTIPLE_SELECT)
class NotesAdapter : BaseAdapter<Notes>(R.layout.item_notes)

object DataUtil {

    val notes = mutableListOf(
        Notes(title = "title 1"),
        Notes(title = "title 2"),
        Notes(title = "title 3"),
        Notes(title = "title 4"),
        Notes(title = "title 5"),
        Notes(title = "title 6"),
        Notes(title = "title 7"),
        Notes(title = "title 8"),
        Notes(title = "title 9"),
        Notes(title = "title 10"),
        Notes(title = "title 11"),
        Notes(title = "title 12"),
        Notes(title = "title 13"),
        Notes(title = "title 14"),
        Notes(title = "title 15"),
        Notes(title = "title 16"),
        Notes(title = "title 17"),
        Notes(title = "title 18"),
        Notes(title = "title 19"),
        Notes(title = "title 20")
    )
}
