package com.dev.anhnd.mybase.utils.media.model

import java.io.File
import java.text.SimpleDateFormat
import java.util.*

abstract class BaseMedia(open val typeMedia: MediaType,
                         open var id: Long = -1L,
                         open var path: String = "",
                         open var dateAdded: Long = -1L
) : MediaModelBase() {

    fun getFile(): File {
        return File(path)
    }

    fun getFileName(): String {
        return getFile().name
    }

    fun getFileExtension(): String {
        return getFile().extension
    }

    fun getFileNameWithoutExtension(): String {
        return getFile().nameWithoutExtension
    }

    fun getFileLastModify(): Long {
        return getFile().lastModified()
    }

    fun getFileLastModify(pattern: String): String {
        return SimpleDateFormat(pattern, Locale.ENGLISH).format(Date(getFileLastModify()))
    }

    fun getFileDateAdded(pattern: String = "yyyy-MM-dd"): String {
        return SimpleDateFormat(pattern, Locale.ENGLISH).format(Date(dateAdded * 1000))
    }

    fun getFileSize(): Long {
        return getFile().length()
    }
}

enum class MediaType {
    IMAGE, AUDIO, VIDEO
}
