package com.dev.anhnd.android_web_service.ui.people

import com.dev.anhnd.android_web_service.model.movies.Result
import com.dev.anhnd.mybase.BaseListItemListener

interface PeopleListener : BaseListItemListener {
    fun onClickItem(position: Int, item: Result)
}