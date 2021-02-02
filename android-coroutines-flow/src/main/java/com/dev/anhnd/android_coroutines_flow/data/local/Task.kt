package com.dev.anhnd.android_coroutines_flow.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.DateFormat


@Entity(tableName = "task_table")
data class Task(var name: String = "",
                var important: Boolean = false,
                var completed: Boolean = false,
                var created: Long = System.currentTimeMillis(),
                @PrimaryKey(autoGenerate = true) val id: Int = 0) {
    val createdDateFormatted: String
        get() = DateFormat.getDateTimeInstance().format(created)
}
