package com.dev.anhnd.android_note_todos

import com.dev.anhnd.mybase.BaseApplication
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class App : BaseApplication() {

    override fun setUp() {

    }

    override fun preferenceName() = getString(R.string.app_name)
}