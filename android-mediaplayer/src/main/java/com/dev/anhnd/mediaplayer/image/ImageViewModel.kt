package com.dev.anhnd.mediaplayer.image

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dev.anhnd.mediaplayer.model.AppImage
import com.dev.anhnd.mediaplayer.repository.MediaRepository
import com.dev.anhnd.mybase.BaseViewModel
import com.dev.anhnd.mybase.utils.work.viewModelDoJob

class ImageViewModel @ViewModelInject constructor(
    private val mediaRepository: MediaRepository
) : BaseViewModel() {

    private val _liveImages by lazy {
        MutableLiveData(mutableListOf<AppImage>())
    }

    val liveImages: LiveData<MutableList<AppImage>> = _liveImages

    fun fetchImages(clazz: Class<AppImage>) {
        viewModelDoJob(
            doIn = {
                mediaRepository.getAllMedia(clazz)
            },
            doOut = {
                _liveImages.value = it
            }
        )
    }
}
