package com.dev.anhnd.android_navigation_component.collection

import android.os.Bundle
import com.dev.anhnd.android_navigation_component.R
import com.dev.anhnd.android_navigation_component.databinding.FragmentCollectionBinding
import com.dev.anhnd.mybase.BaseFragment

class CollectionFragment : BaseFragment<FragmentCollectionBinding>() {

    private val TAG = CollectionFragment::class.java.simpleName
    override fun getLayoutId(): Int = R.layout.fragment_collection

    override fun setup() {

    }

    override fun initBinding() {

    }

    override fun initView() {

    }

    override fun observerViewModel() {
    }

    override fun onViewClick(viewId: Int) {
        when (viewId) {
            R.id.constraint -> {
                navigateTo(R.id.action_collectionFragment_to_previewFragment)
            }
        }
    }
}