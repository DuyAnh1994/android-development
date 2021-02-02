package com.dev.anhnd.android_coroutines_flow.data.local

import androidx.room.*
import com.dev.anhnd.android_coroutines_flow.ui.task.SortOrder
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    fun getTasks(searchQuery: String, sortOrderOrder : SortOrder, hideCompleted:Boolean) : Flow<List<Task>> =
        when(sortOrderOrder) {
            SortOrder.BY_NAME->{
                getTasksSortByName(searchQuery, hideCompleted)
            }
            SortOrder.BY_DATE->{
                getTasksSortByDateCreated(searchQuery, hideCompleted)
            }
        }

    @Query("SELECT * FROM task_table WHERE (completed != :hideCompleted OR completed = 0) AND name LIKE '%' || :searchQuery || '%' ORDER BY important DESC, name")
    fun getTasksSortByName(searchQuery: String, hideCompleted:Boolean): Flow<List<Task>>

    @Query("SELECT * FROM task_table WHERE (completed != :hideCompleted OR completed = 0) AND name LIKE '%' || :searchQuery || '%' ORDER BY important DESC, created")
    fun getTasksSortByDateCreated(searchQuery: String, hideCompleted:Boolean): Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Task)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)
}
