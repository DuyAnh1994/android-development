package com.dev.anhnd.android_mvvm.utils

import com.dev.anhnd.android_mvvm.repository.MainRepository
import com.dev.anhnd.mybase.viewmodel.manual.ViewModelFactory

object InjectorUtils {

    private fun getMainRepository(): MainRepository = MainRepository.getInstance()

    fun providerMainViewModelFactory(): ViewModelFactory =
        ViewModelFactory(getMainRepository())
}