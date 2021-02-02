package com.dev.anhnd.mybase.utils.media

import android.content.Context
import android.database.Cursor
import com.dev.anhnd.mybase.*
import com.dev.anhnd.mybase.utils.media.model.MediaInfo
import com.dev.anhnd.mybase.utils.media.model.MediaModelBase
import java.lang.reflect.Field

fun <T : MediaModelBase> Context.getMedia(clz: Class<T>,
                                          onCheckIfAddItem: (currentList: List<T>, item: T) -> Boolean = { _, _ -> true },
                                          onCheckContinueLoad: (currentList: List<T>, item: T) -> Boolean = { _, _ -> true },
                                          projection: Array<String>? = null,
                                          selection: String? = null,
                                          selectArgs: Array<String>? = null,
                                          sortOrder: String? = null): MutableList<T> {
    val media = clz.newInstance()
    val uri = media.getUri()
    val query = contentResolver.query(
        uri,
        projection,
        selection,
        selectArgs,
        sortOrder
    )
    val data = mutableListOf<T>()
    query?.use { cursor ->
        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            val item = getRow(cursor, clz)
            if (onCheckIfAddItem(data, item)) {
                data.add(item)
            }
            if (!onCheckContinueLoad(data, item)) {
                break
            }
            cursor.moveToNext()
        }
    }
    return data
}

private fun <T : MediaModelBase> getRow(cursor: Cursor?,
                                        clz: Class<T>): T {
    val t = clz.newInstance()
    val fields = t.javaClass.declaredFields
    fields.forEach {
        it.isAccessible = true
        /* Hiện giờ nếu kế thừa mà ko sửa dụng annotation ở lớp con bé nhất thì ở đây ko get được
         * annotation và sẽ lấy giá trị mặc định để fill vào
         * Nên cải thiện để khi lớp con kế thừa mà ko cần override + set annotation của lớp cha
         */
        val annotation = it.getAnnotation(MediaInfo::class.java)
        if (annotation != null) {
            val index = cursor?.getColumnIndex(annotation.getFieldName)
            mappingField(cursor!!, index!!, it, t)
        }
    }
    return t
}

private fun <T : MediaModelBase> mappingField(cursor: Cursor,
                                              index: Int,
                                              f: Field,
                                              t: T) {
    when (f.type) {
        StringClass -> {
            f.set(t, cursor.getString(index))
        }
        ShortClass -> {
            f.set(t, cursor.getShort(index))
        }
        IntClass -> {
            f.setInt(t, cursor.getInt(index))
        }
        FloatClass -> {
            f.setFloat(t, cursor.getFloat(index))
        }
        LongClass -> {
            f.setLong(t, cursor.getLong(index))
        }
        DoubleClass -> {
            f.setDouble(t, cursor.getDouble(index))
        }
    }
}
