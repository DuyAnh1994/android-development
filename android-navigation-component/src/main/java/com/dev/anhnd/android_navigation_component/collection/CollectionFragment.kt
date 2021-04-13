package com.dev.anhnd.android_navigation_component.collection

import com.dev.anhnd.android_navigation_component.R
import com.dev.anhnd.android_navigation_component.databinding.FragmentCollectionBinding
import com.dev.anhnd.android_navigation_component.main.BaseMainFragment
import com.dev.anhnd.mybase.utils.log.logd
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
@WithFragmentBindings
class CollectionFragment : BaseMainFragment<FragmentCollectionBinding>() {

    private val TAG = CollectionFragment::class.java.simpleName

    override fun getLayoutId(): Int = R.layout.fragment_collection

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
            }
        }
    }

    override fun onBackPressed() {
        activityOwner.finish()
    }
}