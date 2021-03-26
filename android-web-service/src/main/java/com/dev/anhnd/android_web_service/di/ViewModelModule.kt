package com.dev.anhnd.android_web_service.di

import com.dev.anhnd.android_web_service.ui.account.AccountViewModel
import com.dev.anhnd.android_web_service.ui.home.HomeViewModel
import com.dev.anhnd.android_web_service.ui.movies.MovieViewModel
import com.dev.anhnd.android_web_service.ui.people.PeopleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeViewModel()
    }
    viewModel {
        AccountViewModel(get())
    }
    viewModel {
        MovieViewModel(get())
    }
    viewModel {
        PeopleViewModel(get())
    }
}
