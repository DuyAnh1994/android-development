package com.dev.anhnd.android_mvvm_di

import com.dev.anhnd.mybase.application.BaseApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : BaseApplication() {


    override fun setUp() {

    }

    override fun preferenceName(): String = getString(R.string.app_name)
}