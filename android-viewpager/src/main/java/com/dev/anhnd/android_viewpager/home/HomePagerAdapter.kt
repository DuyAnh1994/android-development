package com.dev.anhnd.android_viewpager.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomePagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle) {

    val fragments = arrayListOf<Fragment>()
    val titles = arrayListOf<String>()

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

    fun addFragment(fragment: Fragment, title: String, position: Int) {
        fragments.add(position, fragment)
        titles.add(position, title)
    }

}


/*class HomePagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    val fragments = arrayListOf<Fragment>()
    val titles = arrayListOf<String>()

    override fun getCount() = fragments.size

    override fun getItem(position: Int) = fragments[position]

    override fun getPageTitle(position: Int) = titles[position]

    fun addFragment(fragment: Fragment, title: String, position: Int) {
        fragments.add(position, fragment)
        titles.add(position, title)
    }
}*/