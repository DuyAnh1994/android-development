package com.dev.anhnd.mediaplayer.video

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dev.anhnd.mediaplayer.model.AppVideo
import com.dev.anhnd.mediaplayer.repository.MediaRepository
import com.dev.anhnd.mybase.BaseViewModel
import com.dev.anhnd.mybase.utils.work.viewModelDoJob

class VideoViewModel @ViewModelInject constructor(
    private val mediaRepository: MediaRepository
) : BaseViewModel() {

    private val _liveVideos by lazy {
        MutableLiveData(mutableListOf<AppVideo>())
    }

    val liveVideos: LiveData<MutableList<AppVideo>> = _liveVideos

    fun fetchVideos(clazz: Class<AppVideo>) {
        viewModelDoJob(
            doIn = {
                mediaRepository.getAllMedia(clazz, onCheckIfAddItem = { _, item ->
                    if (item.getFileExtension() != "mp4") {
                        return@getAllMedia true
                    }
                    return@getAllMedia false
                }, onCheckContinueLoad = { currentList, _ ->
                    if (currentList.size > 10) {
                        return@getAllMedia false
                    }
                    return@getAllMedia true
                })
            },
            doOut = {
                _liveVideos.value = it
            }
        )
    }
}