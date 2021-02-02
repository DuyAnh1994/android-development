package com.dev.anhnd.android_viewpager.home

import android.os.Bundle
import android.view.View
import com.dev.anhnd.android_viewpager.R
import com.dev.anhnd.android_viewpager.about.AboutFragment
import com.dev.anhnd.android_viewpager.collection.CollectionFragment
import com.dev.anhnd.android_viewpager.databinding.FragmentHomeBinding
import com.dev.anhnd.android_viewpager.main.MainActivity
import com.dev.anhnd.android_viewpager.setting.SettingFragment
import com.dev.anhnd.mybase.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    companion object {
        private val TAG = HomeFragment::class.java.simpleName
        private const val ABOUT_POSITION = 0
        private const val COLLECTION_POSITION = 1
        private const val SETTING_POSITION = 2
    }

    private val aboutFragment = AboutFragment()
    private val collectionFragment = CollectionFragment()
    private val settingFragment = SettingFragment()

    private val homeViewPagerAdapter by lazy {
        HomePagerAdapter(childFragmentManager, lifecycle).apply {
            addFragment(aboutFragment, "About", ABOUT_POSITION)
            addFragment(collectionFragment, "Collection", COLLECTION_POSITION)
            addFragment(settingFragment, "Setting", SETTING_POSITION)
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun setup(savedInstanceState: Bundle?) {

    }

    override fun initBinding() {

    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {
        val homeViewPagerAdapter by lazy {
            HomePagerAdapter(childFragmentManager, lifecycle).apply {
                addFragment(aboutFragment, "About", ABOUT_POSITION)
                addFragment(collectionFragment, "Collection", COLLECTION_POSITION)
                addFragment(settingFragment, "Setting", SETTING_POSITION)
            }
        }
        binding.viewpager.apply {
            offscreenPageLimit = homeViewPagerAdapter.itemCount
            currentItem = ABOUT_POSITION
            adapter = homeViewPagerAdapter
        }
        TabLayoutMediator(binding.tabLayout, binding.viewpager) { tab, position ->
            tab.text = homeViewPagerAdapter.titles[position]
            binding.viewpager.setCurrentItem(tab.position, true)
        }.attach()
    }

    fun getViewPager()  = binding.viewpager

    override fun observerViewModel() {

    }

    override fun onViewClick(viewId: Int) {
        when (viewId) {
            R.id.constraint -> {
            }
        }
    }

}