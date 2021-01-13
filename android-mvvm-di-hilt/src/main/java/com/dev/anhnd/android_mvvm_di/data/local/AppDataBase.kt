package com.dev.anhnd.android_mvvm_di.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dev.anhnd.android_mvvm_di.data.local.notes.Notes
import com.dev.anhnd.android_mvvm_di.data.local.notes.NotesDao
//import com.dev.anhnd.android_mvvm_di.data.local.notes.NotesDAO
//import com.dev.anhnd.android_mvvm_di.data.local.notes.Notes
import com.dev.anhnd.mybase.utils.app.getApplication

@Database(entities = [Notes::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getNotesDao(): NotesDao

    companion object {
        private const val DB_NAME = "Note.db"

        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room
                    .databaseBuilder(getApplication(), AppDataBase::class.java, DB_NAME)
                    .allowMainThreadQueries()
                    .addMigrations()
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
