package com.dev.anhnd.android_list_demo.national

import androidx.lifecycle.MutableLiveData
import com.dev.anhnd.android_list_demo.BR
import com.dev.anhnd.android_list_demo.R
import com.dev.anhnd.android_list_demo.national.SelectedMode.MULTIPLE
import com.dev.anhnd.android_list_demo.national.SelectedMode.SINGLE
import com.dev.anhnd.mybase.BaseDiffCallback
import com.dev.anhnd.mybase.BaseListAdapter
import com.dev.anhnd.mybase.BaseViewHolder
import com.dev.anhnd.mybase.utils.app.postSelf
import java.util.*

class NationalAdapter : BaseListAdapter<National>(
    R.layout.item_national,
    NationalDiffUtilImpl()
) {

    var liveSelected = MutableLiveData(Stack<National>())

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.binding.setVariable(BR.liveSelected, liveSelected)
        super.onBindViewHolder(holder, position)
    }

    fun selected(national: National, multiple: SelectedMode = MULTIPLE) {
        val selected = liveSelected.value ?: Stack()
        if (selected.search(national) != -1) {
            selected.remove(national)
        } else {
            if (multiple == SINGLE) {
                selected.clear()
            }
            selected.add(national)
        }
        liveSelected.postSelf()
    }

    fun remove(national: National) {
        val selected = liveSelected.value ?: Stack()
        if (selected.search(national) != -1) {
            selected.remove(national)
        }
        liveSelected.postSelf()
    }

    private class NationalDiffUtilImpl : BaseDiffCallback<National>() {
        override fun areItemsTheSame(oldItem: National, newItem: National): Boolean {
            return oldItem.name == newItem.name
        }
    }
}
