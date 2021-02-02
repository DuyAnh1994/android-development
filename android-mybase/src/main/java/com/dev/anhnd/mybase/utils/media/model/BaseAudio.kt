package com.dev.anhnd.mybase.utils.media.model

import android.net.Uri
import android.provider.MediaStore

abstract class BaseAudio(override var id: Long = -1L,
                         override var path: String = "",
                         override var dateAdded: Long = -1
) : BaseMedia(
    typeMedia = MediaType.AUDIO,
    id = id,
    path = path,
    dateAdded = dateAdded
), AudioHelper {
    override fun getUri(): Uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
}

interface AudioHelper {
    fun getDuration(): Long
}
