package com.dev.anhnd.mediaplayer.video

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.dev.anhnd.mediaplayer.R
import com.dev.anhnd.mediaplayer.databinding.FragmentVideoBinding
import com.dev.anhnd.mediaplayer.home.HomeFragment
import com.dev.anhnd.mediaplayer.model.AppVideo
import com.dev.anhnd.mybase.BaseFragment
import com.dev.anhnd.mybase.utils.app.observer
import com.dev.anhnd.mybase.utils.log.logd
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoFragment : BaseFragment<FragmentVideoBinding>() {

    private val viewModel by viewModels<VideoViewModel>()

    override fun getLayoutId(): Int = R.layout.fragment_video

    override fun setup() {
        viewModel.fetchVideos(AppVideo::class.java)
    }

    override fun initView() {

    }

    override fun observerViewModel() {
        observer(viewModel.liveVideos) {
            it?.forEach { video ->
                this@VideoFragment.logd(video.getFileName())
            }
        }
    }

    override fun onBackPressed() {
        (parentFragment as HomeFragment).onBackPressed()
    }
}
