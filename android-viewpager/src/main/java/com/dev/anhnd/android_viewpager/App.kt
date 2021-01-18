package com.dev.anhnd.android_viewpager

import com.dev.anhnd.mybase.BaseApplication

class App : BaseApplication() {

    override fun setUp() {

    }

    override fun preferenceName(): String {
        return getString(R.string.app_name)
    }
}