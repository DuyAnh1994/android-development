package com.dev.anhnd.android_list_demo.di

import com.dev.anhnd.android_list_demo.national.NationalViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        NationalViewModel(get())
    }
}
