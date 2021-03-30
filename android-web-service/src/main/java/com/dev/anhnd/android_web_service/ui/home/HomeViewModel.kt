package com.dev.anhnd.android_web_service.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dev.anhnd.android_web_service.data.model.ApiType
import com.dev.anhnd.android_web_service.utils.DataUtils
import com.dev.anhnd.mybase.BaseViewModel

class HomeViewModel : BaseViewModel() {

    private val _apiType by lazy {
        MutableLiveData<MutableList<ApiType>>()
    }
    val apiType: LiveData<MutableList<ApiType>> = _apiType

    fun getApiTypes() {
        _apiType.value = DataUtils.apiType
    }
}