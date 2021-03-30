package com.dev.anhnd.android_list_demo

import com.dev.anhnd.android_list_demo.di.applicationModule
import com.dev.anhnd.android_list_demo.di.repositoryModule
import com.dev.anhnd.android_list_demo.di.viewModelModule
import com.dev.anhnd.mybase.BaseApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : BaseApplication() {

    override fun setUp() {
        startKoin {
            androidContext(this@App)
            modules(applicationModule, viewModelModule, repositoryModule)
        }
    }

    override fun preferenceName() = getString(R.string.app_name)
}