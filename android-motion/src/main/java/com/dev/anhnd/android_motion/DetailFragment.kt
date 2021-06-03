package com.dev.anhnd.android_motion

import com.dev.anhnd.android_coordinator.R
import com.dev.anhnd.android_coordinator.databinding.FragmentDetailBinding
import com.google.android.material.tabs.TabLayoutMediator

class DetailFragment : BaseMainFragment<FragmentDetailBinding>() {

    companion object {
        private const val FIRST_POSITION = 0
        private const val SECOND_POSITION = 1
    }

    private val firstFragment = FirstFragment()

    private val secondFragment = SecondFragment()


    override fun getLayoutId() = R.layout.fragment_detail


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
}