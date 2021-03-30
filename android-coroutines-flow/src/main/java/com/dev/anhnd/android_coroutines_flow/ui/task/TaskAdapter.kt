package com.dev.anhnd.android_coroutines_flow.ui.task

import com.dev.anhnd.android_coroutines_flow.R
import com.dev.anhnd.android_coroutines_flow.data.local.Task
import com.dev.anhnd.mybase.utils.adapter.BaseAdapter
import com.dev.anhnd.mybase.utils.adapter.viewholder.ListItemListener

class TaskAdapter : BaseAdapter<Task>(R.layout.item_task)


interface TaskListener : ListItemListener {
    fun onClickItem(position: Int, task: Task)

    fun onLongLickItem(position: Int, task: Task) = false
}
