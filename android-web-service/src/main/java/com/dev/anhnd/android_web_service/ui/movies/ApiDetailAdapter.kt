package com.dev.anhnd.android_web_service.ui.movies

import com.dev.anhnd.android_web_service.R
import com.dev.anhnd.android_web_service.model.ApiDetail
import com.dev.anhnd.android_web_service.model.ApiType
import com.dev.anhnd.mybase.BaseDiffCallback
import com.dev.anhnd.mybase.BaseListAdapter

class ApiDetailAdapter : BaseListAdapter<ApiDetail>(R.layout.item_api_detail, ApiDetailDiffUtilsImpl()) {

    private class ApiDetailDiffUtilsImpl : BaseDiffCallback<ApiDetail>() {
        override fun areItemsTheSame(oldItem: ApiDetail, newItem: ApiDetail): Boolean {
            return oldItem.name == newItem.name
        }
    }
}
