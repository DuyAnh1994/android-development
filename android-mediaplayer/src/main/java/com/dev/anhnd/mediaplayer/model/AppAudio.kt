package com.dev.anhnd.mediaplayer.model

import android.provider.MediaStore
import com.dev.anhnd.mybase.utils.media.getMediaDuration
import com.dev.anhnd.mybase.utils.media.model.BaseAudio
import com.dev.anhnd.mybase.utils.media.model.MediaInfo

data class AppAudio(@MediaInfo(MediaStore.Audio.AudioColumns._ID)
                    override var id: Long = -1L,
                    @MediaInfo(MediaStore.Audio.AudioColumns.DATA)
                    override var path: String = "",
                    @MediaInfo(MediaStore.Audio.AudioColumns.DATE_ADDED)
                    override var dateAdded: Long = -1
) : BaseAudio(
    id = id,
    path = path,
    dateAdded = dateAdded
) {

    override fun getDuration(): Long = getFile().getMediaDuration()
}
