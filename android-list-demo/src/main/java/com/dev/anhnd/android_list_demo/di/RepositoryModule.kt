package com.dev.anhnd.android_list_demo.di

import com.dev.anhnd.android_list_demo.national.NationalRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        NationalRepository()
    }
}
