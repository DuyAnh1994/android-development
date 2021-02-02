package com.dev.anhnd.android_mvvm.ui.home

import androidx.annotation.LayoutRes
import com.dev.anhnd.mybase.BaseAdapter
import com.dev.anhnd.mybase.BaseDiffCallback

class PhotosAdapter<T : Any>(
    @LayoutRes private val resLayout: Int,
    diffUtil: BaseDiffCallback<T>
) : BaseAdapter<T>(resLayout, diffUtil)