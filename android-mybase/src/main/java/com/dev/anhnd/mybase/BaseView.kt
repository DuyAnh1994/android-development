package com.dev.anhnd.mybase

import androidx.annotation.LayoutRes

interface BaseView {

    @LayoutRes
    fun getLayoutId(): Int

    fun setup() {}

    fun initBinding() {}

    fun beforeInitView() {}

    fun initView() {}

    fun observerViewModel() {}

    fun onViewClick(ViewId:Int) {}
}
