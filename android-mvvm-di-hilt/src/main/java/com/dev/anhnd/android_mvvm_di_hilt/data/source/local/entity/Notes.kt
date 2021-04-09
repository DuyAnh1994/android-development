package com.dev.anhnd.android_mvvm_di_hilt.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table", indices = [Index(value = ["id"], unique = true)])
data class Notes(@PrimaryKey(autoGenerate = true)
                 val id: Int = 0,
                 @ColumnInfo(name = "title")
                 val title: String = "",
                 @ColumnInfo(name = "content")
                 val content: String = ""
)
