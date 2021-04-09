package com.dev.anhnd.android_mvvm_di_hilt.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dev.anhnd.android_mvvm_di_hilt.data.source.local.dao.NotesDao
import com.dev.anhnd.android_mvvm_di_hilt.data.source.local.entity.Notes

@Database(entities = [Notes::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getNotesDao(): NotesDao

    companion object {
        const val DATABASE_NAME = "Note.db"
    }
}
