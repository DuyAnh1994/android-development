package com.dev.anhnd.mediaplayer.video

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.dev.anhnd.mediaplayer.R
import com.dev.anhnd.mediaplayer.databinding.FragmentVideoBinding
import com.dev.anhnd.mediaplayer.home.HomeFragment
import com.dev.anhnd.mediaplayer.main.MainActivity
import com.dev.anhnd.mediaplayer.model.AppVideo
import com.dev.anhnd.mybase.BaseFragment
import com.dev.anhnd.mybase.utils.app.observer
import com.dev.anhnd.mybase.utils.log.logd
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoFragment : BaseFragment<FragmentVideoBinding, MainActivity>() {

    private val viewModel by viewModels<VideoViewModel>()

    override fun getLayoutId(): Int = R.layout.fragment_video

    override fun setup(savedInstanceState: Bundle?) {
        viewModel.fetchVideos(AppVideo::class.java)
    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {

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
