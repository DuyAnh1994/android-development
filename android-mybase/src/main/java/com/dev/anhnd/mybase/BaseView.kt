package com.dev.anhnd.mybase

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes

interface BaseView {

    @LayoutRes
    fun getLayoutId(): Int

    fun setup(savedInstanceState: Bundle?=null) {}

    fun initBinding() {}

    fun beforeInitView() {}

    fun initView(view: View? = null, savedInstanceState: Bundle? = null) {}

    fun observerViewModel() {}

    fun onViewClick(viewId: Int) {}
}
