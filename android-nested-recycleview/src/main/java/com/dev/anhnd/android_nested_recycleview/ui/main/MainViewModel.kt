package com.dev.anhnd.android_nested_recycleview.ui.main

import androidx.lifecycle.MutableLiveData
import com.dev.anhnd.android_nested_recycleview.model.Nation
import com.dev.anhnd.mybase.BaseViewModel
import com.dev.anhnd.mybase.utils.app.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel() {


//    private val _nation = MutableLiveData(Nation())
//
////    val nation = _nation.asLiveData()




    val nation = MutableLiveData(Nation())

    fun setNation(nation: Nation) {
        this.nation.value = nation
    }
}