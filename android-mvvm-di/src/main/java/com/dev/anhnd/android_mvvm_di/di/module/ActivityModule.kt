package com.dev.anhnd.android_mvvm_di.di.module

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class ActivityModule {

}

inline class A(val name:String)