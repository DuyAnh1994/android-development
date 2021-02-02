package com.dev.anhnd.android_mvvm_di.ui.notes.list

import androidx.annotation.LayoutRes
import com.dev.anhnd.mybase.BaseAdapter
import com.dev.anhnd.mybase.BaseDiffCallback

class NotesAdapter<T : Any>(
    @LayoutRes private val resLayout: Int,
    diffUtil: BaseDiffCallback<T>
) : BaseAdapter<T>(resLayout, diffUtil)