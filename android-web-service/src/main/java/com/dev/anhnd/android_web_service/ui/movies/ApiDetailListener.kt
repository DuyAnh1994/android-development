package com.dev.anhnd.android_web_service.ui.movies

import com.dev.anhnd.android_web_service.data.model.ApiDetail
import com.dev.anhnd.mybase.utils.adapter.viewholder.ListItemListener

interface ApiDetailListener : ListItemListener {
    fun onClickItem(position: Int, item: ApiDetail)
}