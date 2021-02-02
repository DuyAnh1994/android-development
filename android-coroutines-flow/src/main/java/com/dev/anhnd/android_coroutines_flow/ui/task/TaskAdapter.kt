package com.dev.anhnd.android_coroutines_flow.ui.task

import com.dev.anhnd.android_coroutines_flow.R
import com.dev.anhnd.android_coroutines_flow.data.local.Task
import com.dev.anhnd.mybase.BaseDiffCallback
import com.dev.anhnd.mybase.BaseListAdapter
import com.dev.anhnd.mybase.BaseListItemListener

class TaskAdapter : BaseListAdapter<Task>(R.layout.item_task, TaskDiffUtilsImpl()) {

}


class TaskDiffUtilsImpl : BaseDiffCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.id == newItem.id
                || oldItem.completed == newItem.completed
                || oldItem.important == newItem.important
    }
}

interface TaskListener : BaseListItemListener {
    fun onClickItem(position: Int, task: Task)

    fun onLongLickItem(position: Int, task: Task) = false
}
