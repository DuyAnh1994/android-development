package com.dev.anhnd.mediaplayer.model

import android.provider.MediaStore
import android.util.Size
import com.dev.anhnd.mybase.utils.media.getMediaDuration
import com.dev.anhnd.mybase.utils.media.getVideoResolution
import com.dev.anhnd.mybase.utils.media.model.BaseVideo
import com.dev.anhnd.mybase.utils.media.model.MediaInfo

data class AppVideo(@MediaInfo(MediaStore.Video.VideoColumns._ID)
                    override var id: Long = -1L,
                    @MediaInfo(MediaStore.Video.VideoColumns.DATA)
                    override var path: String = "",
                    @MediaInfo(MediaStore.Video.VideoColumns.DATE_ADDED)
                    override var dateAdded: Long = -1
) : BaseVideo(
    id = id,
    path = path,
    dateAdded = dateAdded
) {

    override fun getDuration(): Long = getFile().getMediaDuration()

    override fun getResolution(): Size = getFile().getVideoResolution()
}
