package com.dev.anhnd.android_navigation_component.search

import com.dev.anhnd.android_navigation_component.R
import com.dev.anhnd.android_navigation_component.databinding.FragmentSearchBinding
import com.dev.anhnd.android_navigation_component.main.BaseMainFragment
import com.dev.anhnd.mybase.utils.log.logd
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
@WithFragmentBindings
class SearchFragment : BaseMainFragment<FragmentSearchBinding>() {

    private val TAG = SearchFragment::class.java.simpleName

    override fun getLayoutId(): Int = R.layout.fragment_search

    override fun setup() {
        logd("setup: ")
    }

    override fun initBinding() {

    }

    override fun initView() {

    }

    override fun observerViewModel() {
    }

    override fun onViewClick(viewId: Int) {
        when (viewId) {
            R.id.btnAbout -> {
                mainViewModel.hideMenu()
                navigateTo(R.id.action_searchFragment_to_nav_graph)
            }
        }
    }

    override fun onBackPressed() {
        activityOwner.finish()
    }
}