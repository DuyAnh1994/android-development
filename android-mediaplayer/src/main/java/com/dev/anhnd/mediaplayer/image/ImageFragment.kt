package com.dev.anhnd.mediaplayer.image

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.dev.anhnd.mediaplayer.R
import com.dev.anhnd.mediaplayer.databinding.FragmentImageBinding
import com.dev.anhnd.mediaplayer.home.HomeFragment
import com.dev.anhnd.mediaplayer.main.MainActivity
import com.dev.anhnd.mediaplayer.model.AppImage
import com.dev.anhnd.mybase.BaseFragment
import com.dev.anhnd.mybase.utils.app.observer
import com.dev.anhnd.mybase.utils.log.logd
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageFragment : BaseFragment<FragmentImageBinding, MainActivity>() {

    private val viewModel by viewModels<ImageViewModel>()

    override fun getLayoutId(): Int = R.layout.fragment_image

    override fun setup(savedInstanceState: Bundle?) {
        viewModel.fetchImages(AppImage::class.java)
    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {

    }

    override fun observerViewModel() {
        observer(viewModel.liveImages) {
            it?.forEach { image ->
                this@ImageFragment.logd(image.getFileName())
            }
        }
    }

    override fun onBackPressed() {
        (parentFragment as HomeFragment).onBackPressed()
    }
}
