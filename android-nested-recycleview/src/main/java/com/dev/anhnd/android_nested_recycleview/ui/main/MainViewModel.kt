package com.dev.anhnd.android_nested_recycleview.ui.main

import androidx.lifecycle.MutableLiveData
import com.dev.anhnd.android_nested_recycleview.model.Nation
import com.dev.anhnd.mybase.BaseViewModel
import com.dev.anhnd.mybase.utils.app.asLiveData

class MainViewModel : BaseViewModel() {


    private val _nation = MutableLiveData(Nation())

    val nation = _nation.asLiveData()

    fun setNation(nation: Nation) {
        _nation.value = nation
    }
}