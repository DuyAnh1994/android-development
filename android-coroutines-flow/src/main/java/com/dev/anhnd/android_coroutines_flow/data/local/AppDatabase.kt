package com.dev.anhnd.android_coroutines_flow.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.dev.anhnd.android_coroutines_flow.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getTaskDao(): TaskDao

    /*companion object {
        private const val DB_NAME = "Task.db"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room
                    .databaseBuilder(getApplication(), AppDatabase::class.java, DB_NAME)
                    .allowMainThreadQueries()
                    .addMigrations()
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }*/

    class Callback @Inject constructor(
        private val database: Provider<AppDatabase>,
        @ApplicationScope private val appScope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            val dao = database.get().getTaskDao()

            appScope.launch {
                dao.insert(Task("1"))
                dao.insert(Task("2"))
                dao.insert(Task("3"))
                dao.insert(Task("4"))
                dao.insert(Task("5"))
                dao.insert(Task("6"))
                dao.insert(Task("7"))
                dao.insert(Task("8"))
                dao.insert(Task("9"))
                dao.insert(Task("10"))
                dao.insert(Task("11"))
                dao.insert(Task("12"))
                dao.insert(Task("13"))
                dao.insert(Task("14"))
                dao.insert(Task("15"))
                dao.insert(Task("16"))
                dao.insert(Task("17"))
                dao.insert(Task("18"))
                dao.insert(Task("19"))
                dao.insert(Task("20"))
            }
        }
    }
}
