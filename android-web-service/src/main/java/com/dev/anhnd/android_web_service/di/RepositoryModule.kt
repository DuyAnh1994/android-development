package com.dev.anhnd.android_web_service.di

import com.dev.anhnd.android_web_service.repository.AccountRepository
import com.dev.anhnd.android_web_service.repository.MovieRepository
import com.dev.anhnd.android_web_service.repository.PeopleRepository
import com.dev.anhnd.android_web_service.ui.home.HomeViewModel
import org.koin.dsl.module

val repositoryModule = module {
    single {
        AccountRepository()
    }
    single {
        MovieRepository(get())
    }
    single {
        PeopleRepository(get())
    }
}
