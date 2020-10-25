package com.dev.anhnd.android_mvvm_di.di.koin.module

import com.dev.anhnd.android_mvvm_di.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(get())
    }
}