package com.dev.anhnd.android_mvvm.ui.home

import androidx.annotation.LayoutRes
import com.dev.anhnd.mybase.BaseListAdapter
import com.dev.anhnd.mybase.BaseDiffCallback

class PhotosAdapter<T : Any>(
    @LayoutRes private val resLayout: Int,
    diffUtil: BaseDiffCallback<T>
) : BaseListAdapter<T>(resLayout, diffUtil)