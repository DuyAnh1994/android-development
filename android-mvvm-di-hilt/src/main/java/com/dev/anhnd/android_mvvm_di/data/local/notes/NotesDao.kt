package com.dev.anhnd.android_mvvm_di.data.local.notes

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(notes: Notes)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(notes: Notes)

    @Delete
    fun delete(notes: Notes)

    @Query("SELECT * FROM notes_table")
    fun getAllNotes(): Flow<List<Notes>>

    @Query("SELECT * FROM notes_table WHERE title = :title")
    fun getNotesByTitle(title: String): Flow<List<Notes>>
}
