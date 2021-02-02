package com.dev.anhnd.mediaplayer.audio

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.dev.anhnd.mediaplayer.R
import com.dev.anhnd.mediaplayer.databinding.FragmentAudioBinding
import com.dev.anhnd.mediaplayer.home.HomeFragment
import com.dev.anhnd.mediaplayer.main.MainActivity
import com.dev.anhnd.mediaplayer.model.AppAudio
import com.dev.anhnd.mybase.BaseFragment
import com.dev.anhnd.mybase.utils.app.observer
import com.dev.anhnd.mybase.utils.log.logd
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AudioFragment : BaseFragment<FragmentAudioBinding, MainActivity>() {

    private val viewModel by viewModels<AudioViewModel>()

    override fun getLayoutId(): Int = R.layout.fragment_audio

    override fun setup(savedInstanceState: Bundle?) {
        viewModel.fetchAudios(AppAudio::class.java)
    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {

    }

    override fun observerViewModel() {
        observer(viewModel.liveVideos) {
            it?.forEach { audio ->
                this@AudioFragment.logd(audio.getFileName())
            }
        }
    }

    override fun onBackPressed() {
        (parentFragment as HomeFragment).onBackPressed()
    }
}
