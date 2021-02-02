package com.dev.anhnd.mediaplayer.repository

import com.dev.anhnd.mybase.utils.app.getApplication
import com.dev.anhnd.mybase.utils.media.getMedia
import com.dev.anhnd.mybase.utils.media.model.MediaModelBase
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MediaRepository @Inject constructor() {

    fun <T : MediaModelBase> getAllMedia(
        clazz: Class<T>,
        onCheckIfAddItem: (currentList: List<T>, item: T) -> Boolean = { _, _ -> true },
        onCheckContinueLoad: (currentList: List<T>, item: T) -> Boolean = { _, _ -> true },
    ) = getApplication().getMedia(
        clz = clazz,
        onCheckIfAddItem = onCheckIfAddItem,
        onCheckContinueLoad = onCheckContinueLoad
    )
}
