package com.dev.anhnd.mediaplayer.model

import android.provider.MediaStore
import android.util.Size
import com.dev.anhnd.mybase.utils.media.getImageResolution
import com.dev.anhnd.mybase.utils.media.model.BaseImage
import com.dev.anhnd.mybase.utils.media.model.MediaInfo

data class AppImage(@MediaInfo(MediaStore.Images.ImageColumns._ID)
                    override var id: Long = -1L,
                    @MediaInfo(MediaStore.Images.ImageColumns.DATA)
                    override var path: String = "",
                    @MediaInfo(MediaStore.Images.ImageColumns.DATE_ADDED)
                    override var dateAdded: Long = -1
) : BaseImage(
    id = id,
    path = path,
    dateAdded = dateAdded
) {

    override fun getResolution(): Size = getFile().getImageResolution()
}
