package com.dev.anhnd.android_web_service.ui.movies

import com.dev.anhnd.android_web_service.model.ApiDetail
import com.dev.anhnd.android_web_service.model.ApiType
import com.dev.anhnd.mybase.BaseListItemListener

interface ApiDetailListener : BaseListItemListener {
    fun onClickItem(position: Int, item: ApiDetail)
}