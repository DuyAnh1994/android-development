package com.dev.anhnd.android_mvvm_di.di.koin.module

import com.dev.anhnd.android_mvvm_di.repository.MainRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        MainRepository(get())
    }
}