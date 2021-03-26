package com.dev.anhnd.android_web_service.ui.home

import com.dev.anhnd.android_web_service.R
import com.dev.anhnd.android_web_service.model.ApiType
import com.dev.anhnd.mybase.BaseDiffCallback
import com.dev.anhnd.mybase.BaseListAdapter

class ApiTypeAdapter : BaseListAdapter<ApiType>(R.layout.item_api_type, ApiTypeDiffUtilsImpl()) {

    private class ApiTypeDiffUtilsImpl : BaseDiffCallback<ApiType>() {
        override fun areItemsTheSame(oldItem: ApiType, newItem: ApiType): Boolean {
            return oldItem.name == newItem.name
        }
    }
}
