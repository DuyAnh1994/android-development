package com.dev.anhnd.mediaplayer.audio

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dev.anhnd.mediaplayer.model.AppAudio
import com.dev.anhnd.mediaplayer.repository.MediaRepository
import com.dev.anhnd.mybase.BaseViewModel
import com.dev.anhnd.mybase.utils.work.viewModelDoJob

class AudioViewModel @ViewModelInject constructor(
    private val mediaRepository: MediaRepository
) : BaseViewModel() {

    private val _liveAudios by lazy {
        MutableLiveData(mutableListOf<AppAudio>())
    }

    val liveVideos: LiveData<MutableList<AppAudio>> = _liveAudios

    fun fetchAudios(clazz: Class<AppAudio>) {
        viewModelDoJob(
            doIn = {
                mediaRepository.getAllMedia(clazz)
            },
            doOut = {
                _liveAudios.value = it
            }
        )
    }
}