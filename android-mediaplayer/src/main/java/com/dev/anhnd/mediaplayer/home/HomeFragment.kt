package com.dev.anhnd.mediaplayer.home

import android.os.Bundle
import com.dev.anhnd.mediaplayer.R
import com.dev.anhnd.mediaplayer.audio.AudioFragment
import com.dev.anhnd.mediaplayer.databinding.FragmentHomeBinding
import com.dev.anhnd.mediaplayer.image.ImageFragment
import com.dev.anhnd.mediaplayer.video.VideoFragment
import com.dev.anhnd.mybase.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    companion object {
        private const val IMAGE_POSITION = 0
        private const val AUDIO_POSITION = 1
        private const val VIDEO_POSITION = 2
    }

    private val videoFragment = VideoFragment()
    private val audioFragment = AudioFragment()
    private val imageFragment = ImageFragment()

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun setup() {

    }

    override fun initView() {
        val viewPagerAdapter by lazy {
            HomeViewPagerAdapter(childFragmentManager, lifecycle).apply {
                addFragment(imageFragment, "Image", IMAGE_POSITION)
                addFragment(audioFragment, "Audio", AUDIO_POSITION)
                addFragment(videoFragment, "Video", VIDEO_POSITION)
            }
        }
        binding.viewpager.apply {
            offscreenPageLimit = viewPagerAdapter.itemCount
            adapter = viewPagerAdapter
            post {
                currentItem = VIDEO_POSITION
            }
        }

        TabLayoutMediator(binding.tabLayout, binding.viewpager) { tab, position ->
            tab.text = viewPagerAdapter.titles[position]
            binding.viewpager.setCurrentItem(position, true)
        }.attach()
    }

    override fun observerViewModel() {

    }

    override fun onBackPressed() {
        activityOwner.finish()
    }
}
