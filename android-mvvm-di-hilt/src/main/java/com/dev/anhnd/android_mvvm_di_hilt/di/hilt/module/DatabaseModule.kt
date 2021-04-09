package com.dev.anhnd.android_mvvm_di_hilt.di.hilt.module

import androidx.room.Room
import com.dev.anhnd.android_mvvm_di_hilt.data.source.local.dao.NotesDao
import com.dev.anhnd.android_mvvm_di_hilt.data.source.local.database.AppDataBase
import com.dev.anhnd.mybase.utils.app.getApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(): AppDataBase {
        return Room.databaseBuilder(
            getApplication(),
            AppDataBase::class.java,
            AppDataBase.DATABASE_NAME
        )
            .allowMainThreadQueries()
            .addMigrations()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNotesDao(appDataBase: AppDataBase): NotesDao {
        return appDataBase.getNotesDao()
    }
}