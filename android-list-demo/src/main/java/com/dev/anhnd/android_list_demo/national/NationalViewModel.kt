package com.dev.anhnd.android_list_demo.national

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dev.anhnd.android_list_demo.utils.DataUtils
import com.dev.anhnd.mybase.utils.app.postSelf

//@HiltViewModel
class NationalViewModel constructor(nationalRepository: NationalRepository) : ViewModel() {
//class NationalViewModel constructor() : ViewModel() {

    val liveNationals by lazy {
        MutableLiveData(mutableListOf<National>())
    }

    fun getList() {
        liveNationals.value = DataUtils.nationals
    }

    fun remove(national: National) {
        liveNationals.value?.remove(national)
        liveNationals.postSelf()
    }
}
