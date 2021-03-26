package com.dev.anhnd.android_web_service

import com.dev.anhnd.android_web_service.di.applicationModule
import com.dev.anhnd.android_web_service.di.repositoryModule
import com.dev.anhnd.android_web_service.di.viewModelModule
import com.dev.anhnd.mybase.BaseApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class App : BaseApplication() {


    override fun setUp() {
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                applicationModule,
                viewModelModule,
                repositoryModule
            )
        }
    }

    override fun preferenceName() = getString(R.string.app_name)
}