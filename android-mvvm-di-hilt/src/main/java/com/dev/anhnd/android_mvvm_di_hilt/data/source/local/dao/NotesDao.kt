package com.dev.anhnd.android_mvvm_di_hilt.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dev.anhnd.android_mvvm_di_hilt.data.source.local.entity.Notes
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
    fun getAllNotes(): Flow<MutableList<Notes>>
//    fun getAllNotes(): LiveData<MutableList<Notes>>

    @Query("SELECT * FROM notes_table WHERE title = :title")
    fun getNotesByTitle(title: String): Flow<List<Notes>>
}
