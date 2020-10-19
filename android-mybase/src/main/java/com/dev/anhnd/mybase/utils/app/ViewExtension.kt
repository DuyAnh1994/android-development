package com.dev.anhnd.mybase.utils.app

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dev.anhnd.mybase.activity.BaseActivity
import com.dev.anhnd.mybase.fragment.BaseFragment
import com.dev.anhnd.mybase.viewmodel.manual.BaseViewModel

const val TAG = "MyBase"

fun <T : BaseViewModel> BaseActivity<ViewDataBinding>.createViewModel(clz: Class<T>): T {
    return ViewModelProvider(this)[clz]
}

fun <T : BaseViewModel> BaseFragment<ViewDataBinding, BaseActivity<ViewDataBinding>>.createViewModel(
    clz: Class<T>
): T {
    return ViewModelProvider(this)[clz]
}

fun <T> BaseActivity<*>.observer(liveData: LiveData<T>, onChange: (T?) -> Unit) {
    liveData.observe(this, Observer(onChange))
}

fun <T> BaseFragment<*, *>.observer(liveData: LiveData<T>, onChange: (T?) -> Unit) {
    liveData.observe(viewLifecycleOwner, Observer(onChange))
}


fun <T> MutableLiveData<T>.setAndPostValue(data: T) {
    value = data
    postValue(data)
}




