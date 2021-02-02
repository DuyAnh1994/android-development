package com.dev.anhnd.android_coroutines_flow.di

import android.app.Application
import androidx.room.Room
import com.dev.anhnd.android_coroutines_flow.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideDatabase(app: Application,
                        callback: AppDatabase.Callback
    ) =
        Room.databaseBuilder(app, AppDatabase::class.java, "task.db")
            .fallbackToDestructiveMigration()
            .addCallback(callback)
            .build()

    @Provides
    fun provideTaskDao(db: AppDatabase) = db.getTaskDao()

    @ApplicationScope
    @Provides
    @Singleton
    fun providerApplicationScope() = CoroutineScope(SupervisorJob())
}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope