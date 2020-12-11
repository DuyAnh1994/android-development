package com.dev.anhnd.mybase

import android.view.View
import androidx.annotation.LayoutRes

interface BaseView {

    @LayoutRes
    fun getLayoutId(): Int

    fun setup() {}

    fun initBinding() {}

    fun beforeInitView() {}

    fun initView() {}

    fun observerViewModel()

    fun hideKeyBoard(v: View) {}

    fun showKeyBoard(v: View) {}
}