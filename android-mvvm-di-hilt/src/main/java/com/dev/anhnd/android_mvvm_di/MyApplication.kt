package com.dev.anhnd.android_mvvm_di

import com.dev.anhnd.android_mvvm_di.di.koin.module.appModule
import com.dev.anhnd.android_mvvm_di.di.koin.module.repositoryModule
import com.dev.anhnd.android_mvvm_di.di.koin.module.viewModelModule
import com.dev.anhnd.mybase.BaseApplication
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@HiltAndroidApp
class MyApplication : BaseApplication() {

    override fun setUp() {
        /*startKoin {
            androidContext(this@MyApplication)
            modules(listOf(appModule, repositoryModule, viewModelModule))
        }*/
    }

    override fun preferenceName(): String = getString(R.string.app_name)
}
