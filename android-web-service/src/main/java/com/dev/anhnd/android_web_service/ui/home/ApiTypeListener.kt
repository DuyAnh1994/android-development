package com.dev.anhnd.android_web_service.ui.home

import com.dev.anhnd.android_web_service.model.ApiType
import com.dev.anhnd.mybase.BaseListItemListener

interface ApiTypeListener : BaseListItemListener {
    fun onClickItem(position: Int, item: ApiType)
}