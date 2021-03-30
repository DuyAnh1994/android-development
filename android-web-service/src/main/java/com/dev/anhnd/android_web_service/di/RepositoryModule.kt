package com.dev.anhnd.android_web_service.di

import com.dev.anhnd.android_web_service.data.source.repository.AccountRepository
import com.dev.anhnd.android_web_service.data.source.repository.MovieRepository
import com.dev.anhnd.android_web_service.data.source.repository.PeopleRepository
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
