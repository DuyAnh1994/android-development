package com.dev.anhnd.android_motion

import android.util.Log
import com.dev.anhnd.android_coordinator.R
import com.dev.anhnd.android_coordinator.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment  : BaseMainFragment<FragmentHomeBinding>() {

    companion object {
        private val TAG = HomeFragment::class.java.simpleName
        private const val FIRST_POSITION = 0
        private const val SECOND_POSITION = 1
    }

    private val firstFragment =FirstFragment()

    private val secondFragment = SecondFragment()


    override fun getLayoutId() = R.layout.fragment_home

    override fun initBinding() {

    }

    override fun initView() {
        val viewPagerAdapter by lazy {
            ViewPager(childFragmentManager, lifecycle).apply {
                addFragment(firstFragment, "First", FIRST_POSITION)
                addFragment(secondFragment, "Second", SECOND_POSITION)
            }
        }
        binding.viewpager.apply {
            offscreenPageLimit = viewPagerAdapter.itemCount
            adapter = viewPagerAdapter
            post {
                currentItem = FIRST_POSITION
            }
        }

        TabLayoutMediator(binding.tabLayout, binding.viewpager) { tab, position ->
            tab.text = viewPagerAdapter.titles[position]
            binding.viewpager.setCurrentItem(position, true)
        }.attach()
    }

    override fun onViewClick(viewId: Int) {
        when (viewId) {
            R.id.ivBack -> {
                onBackPressed()
            }
        }
    }

    override fun onBackPressed() {
        Log.d(TAG, "onBackPressed: ")
        backScreen()
    }
}