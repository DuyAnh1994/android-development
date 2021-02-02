package com.dev.anhnd.mybase.utils.media.model

import android.net.Uri
import android.provider.MediaStore
import android.util.Size

abstract class BaseImage(override var id: Long = -1L,
                         override var path: String = "",
                         override var dateAdded: Long = -1L
) : BaseMedia(
    typeMedia = MediaType.IMAGE,
    id = id,
    path = path,
    dateAdded = dateAdded
), ImageHelper {
    override fun getUri(): Uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
}

interface ImageHelper {
    fun getResolution(): Size
}
