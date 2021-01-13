package com.dev.anhnd.android_mvvm_di.di.hilt.module

import com.dev.anhnd.android_mvvm_di.data.local.AppDataBase
import com.dev.anhnd.android_mvvm_di.data.local.notes.NotesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(): AppDataBase {
        return AppDataBase.getDatabase()
    }

    @Provides
    fun provideNotesDao(appDataBase: AppDataBase): NotesDao {
        return appDataBase.getNotesDao()
    }
}