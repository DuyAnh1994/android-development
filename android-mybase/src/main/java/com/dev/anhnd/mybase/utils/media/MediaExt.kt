package com.dev.anhnd.mybase.utils.media

import android.media.MediaMetadataRetriever
import android.net.Uri
import android.provider.MediaStore
import android.util.Size
import com.dev.anhnd.mybase.utils.app.getApplication
import java.io.File

fun File.getMediaDuration(): Long {
    if (!exists()) {
        return 0
    }
    var duration = -1L
    try {
        val retriever = MediaMetadataRetriever()
        retriever.setDataSource(getApplication(), Uri.fromFile(this))
        duration = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)?.toLong()!!
        retriever.release()
    } catch (e: Exception) {
        e.printStackTrace()
        return duration
    }
    return duration
}

fun File.getVideoResolution(): Size {
    if (!exists()) {
        return Size(0, 0)
    }
    val size: Size
    try {
        val retriever = MediaMetadataRetriever()
        retriever.setDataSource(getApplication(), Uri.fromFile(this))
        val width = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_WIDTH)?.toInt()
            ?: 0
        val height = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_VIDEO_HEIGHT)?.toInt()
            ?: 0
        size = Size(width, height)
    } catch (e: Exception) {
        e.printStackTrace()
        return Size(0, 0)
    }
    return size
}

fun File.getImageResolution(): Size {
    if (!exists()) {
        return Size(0, 0)
    }
    val size: Size
    try {
        val bitmap = MediaStore.Images.Media.getBitmap(getApplication().contentResolver, Uri.fromFile(this))
        val width = bitmap.width
        val height = bitmap.height
        size = Size(width, height)
    } catch (e: Exception) {
        e.printStackTrace()
        return Size(0, 0)
    }
    return size
}
