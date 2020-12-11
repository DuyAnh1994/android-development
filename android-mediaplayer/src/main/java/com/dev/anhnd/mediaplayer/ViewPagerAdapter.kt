package com.dev.anhnd.mediaplayer

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle) {

    private val fragments = arrayListOf<Fragment>()
    private val titles = arrayListOf<String>()

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

    fun getTitle(position: Int) = titles[position]

    fun addFragment(fragment: Fragment, title: String, position: Int) {
        fragments.add(position, fragment)
        titles.add(position, title)
    }
}