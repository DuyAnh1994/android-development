package com.dev.anhnd.mybase.model

import android.view.View
import androidx.annotation.LayoutRes

interface IBase {

    @LayoutRes
    fun getLayoutId(): Int = -1

    fun beforeSetup() {}

    fun setup()

    fun observerViewModel()

    fun hideKeyBoard() {}

    fun showKeyBoard(view: View) {}

    fun hideLoading() {}

    fun showLoading() {}

    fun showMessage(message: String) {}

    fun showMessage(resId: Int) {}
}