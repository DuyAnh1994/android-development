package com.dev.anhnd.mediaplayer

import com.dev.anhnd.mediaplayer.databinding.ActivityMainBinding
import com.dev.anhnd.mybase.BaseActivity
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : BaseActivity<ActivityMainBinding>() {

    companion object {
        private const val COMPRESS_POSITION = 0
        private const val EXTRACT_POSITION = 1
    }

    private val compressFragment = CompressFragment()
    private val extractFragment = ExtractFragment()

    private val adapterViewPager by lazy {
        ViewPagerAdapter(supportFragmentManager, lifecycle).apply {
            addFragment(compressFragment, "Compress", COMPRESS_POSITION)
            addFragment(extractFragment, "Extract", EXTRACT_POSITION)
        }
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun setup() {
        binding.viewpager.apply {
            offscreenPageLimit = adapterViewPager.itemCount
            adapter = adapterViewPager
            currentItem = COMPRESS_POSITION
        }
        TabLayoutMediator(binding.tabLayout, binding.viewpager) { tab, position ->
            tab.text = String.format(adapterViewPager.getTitle(position))
        }.attach()
    }

    override fun initView() {

    }

    override fun observerViewModel() {
    }
}