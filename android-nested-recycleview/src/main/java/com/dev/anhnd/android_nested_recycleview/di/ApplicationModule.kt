package com.dev.anhnd.android_nested_recycleview.di

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.SavedStateViewModelFactory
import com.dev.anhnd.mybase.utils.app.getApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApplicationModule {

//    @Singleton
//    @Provides
//    fun provider() : SavedStateHandle {
//        return SavedStateHandle()
//    }
}