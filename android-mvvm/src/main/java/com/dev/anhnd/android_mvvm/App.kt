package com.dev.anhnd.android_mvvm

import com.dev.anhnd.mybase.BaseApplication

class App : BaseApplication() {

    override fun setUp() {

    }

    override fun preferenceName(): String = getString(R.string.app_name)
}