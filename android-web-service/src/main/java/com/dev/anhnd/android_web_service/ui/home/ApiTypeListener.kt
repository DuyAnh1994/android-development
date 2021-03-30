package com.dev.anhnd.android_web_service.ui.home

import com.dev.anhnd.android_web_service.data.model.ApiType
import com.dev.anhnd.mybase.utils.adapter.viewholder.ListItemListener

interface ApiTypeListener : ListItemListener {
    fun onClickItem(position: Int, item: ApiType)
}