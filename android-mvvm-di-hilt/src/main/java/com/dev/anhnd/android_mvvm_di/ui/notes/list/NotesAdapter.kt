package com.dev.anhnd.android_mvvm_di.ui.notes.list

import androidx.lifecycle.MutableLiveData
import com.dev.anhnd.android_mvvm_di.BR
import com.dev.anhnd.android_mvvm_di.R
import com.dev.anhnd.android_mvvm_di.data.local.notes.Notes
import com.dev.anhnd.mybase.BaseDiffCallback
import com.dev.anhnd.mybase.BaseListAdapter
import com.dev.anhnd.mybase.BaseViewHolder
import com.dev.anhnd.mybase.utils.app.postSelf
import java.util.*

class NotesAdapter : BaseListAdapter<Notes>(R.layout.item_notes, NotesDiffUtilsImpl()) {

    var liveSelected = MutableLiveData(Stack<Notes>())

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.binding.setVariable(BR.liveSelected, liveSelected)
        super.onBindViewHolder(holder, position)
    }

    fun selected(position: Int, item: Notes) {
        val selected = liveSelected.value ?: Stack()
        if (selected.search(item) == -1) {
            selected.add(item)
        } else {
            selected.remove(item)
        }
        liveSelected.postSelf()
        notifyItemChanged(position, item)
        notifyItemRangeChanged(position, itemCount - position, item)
    }
}


private class NotesDiffUtilsImpl : BaseDiffCallback<Notes>() {
    override fun areItemsTheSame(oldItem: Notes, newItem: Notes): Boolean {
        return (oldItem.title == newItem.title)
    }

    override fun areContentsTheSame(oldItem: Notes, newItem: Notes): Boolean {
        return oldItem == newItem
    }
}

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