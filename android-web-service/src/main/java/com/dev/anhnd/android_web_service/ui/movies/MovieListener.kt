package com.dev.anhnd.android_web_service.ui.movies

import com.dev.anhnd.android_web_service.data.model.movies.Result
import com.dev.anhnd.mybase.utils.adapter.viewholder.ListItemListener

interface MovieListener : ListItemListener {
    fun onClickItem(position: Int, item: Result)
}