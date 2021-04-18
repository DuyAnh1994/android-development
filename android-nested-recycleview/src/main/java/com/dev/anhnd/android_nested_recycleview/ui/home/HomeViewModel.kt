package com.dev.anhnd.android_nested_recycleview.ui.home

import androidx.lifecycle.MutableLiveData
import com.dev.anhnd.android_nested_recycleview.model.Continents
import com.dev.anhnd.android_nested_recycleview.utils.DataUtils
import com.dev.anhnd.mybase.BaseViewModel
import com.dev.anhnd.mybase.utils.app.asLiveData

class HomeViewModel : BaseViewModel() {

    private val _continents = MutableLiveData(mutableListOf<Continents>())

    val continents = _continents.asLiveData()

    fun getContinents() {
        _continents.value = DataUtils.continents
    }
}