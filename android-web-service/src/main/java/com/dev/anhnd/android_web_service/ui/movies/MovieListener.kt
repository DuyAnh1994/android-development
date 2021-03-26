package com.dev.anhnd.android_web_service.ui.movies

import com.dev.anhnd.android_web_service.model.movies.Result
import com.dev.anhnd.mybase.BaseListItemListener

interface MovieListener : BaseListItemListener {
    fun onClickItem(position: Int, item: Result)
}