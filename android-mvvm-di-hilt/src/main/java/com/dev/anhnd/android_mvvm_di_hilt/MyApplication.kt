package com.dev.anhnd.android_mvvm_di_hilt

import com.dev.anhnd.mybase.BaseApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : BaseApplication() {


    private var a : String = ""

    override fun setUp() {

    }

    override fun preferenceName(): String = getString(R.string.app_name)
}
