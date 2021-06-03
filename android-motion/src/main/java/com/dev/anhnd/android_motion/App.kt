package com.dev.anhnd.android_motion

import com.dev.anhnd.android_coordinator.R
import com.dev.anhnd.mybase.BaseApplication

class App : BaseApplication() {
    override fun setUp() {

    }

    override fun preferenceName() = getString(R.string.app_name)


}