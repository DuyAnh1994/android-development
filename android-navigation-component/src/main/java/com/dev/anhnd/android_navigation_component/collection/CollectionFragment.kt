package com.dev.anhnd.android_navigation_component.collection

import android.os.Bundle
import android.util.Log
import android.view.View
import com.dev.anhnd.android_navigation_component.R
import com.dev.anhnd.android_navigation_component.databinding.FragmentCollectionBinding
import com.dev.anhnd.android_navigation_component.main.MainActivity
import com.dev.anhnd.mybase.BaseFragment

class CollectionFragment : BaseFragment<FragmentCollectionBinding, MainActivity>() {

    private val TAG = CollectionFragment::class.java.simpleName
    override fun getLayoutId(): Int = R.layout.fragment_collection

    override fun setup(savedInstanceState: Bundle?) {

    }

    override fun initBinding() {

    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {

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