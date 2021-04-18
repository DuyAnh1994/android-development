package com.dev.anhnd.android_nested_recycleview.ui.home

import androidx.fragment.app.viewModels
import com.dev.anhnd.android_nested_recycleview.R
import com.dev.anhnd.android_nested_recycleview.databinding.FragmentHomeBinding
import com.dev.anhnd.android_nested_recycleview.model.Nation
import com.dev.anhnd.android_nested_recycleview.ui.main.BaseMainFragment
import com.dev.anhnd.mybase.utils.app.observer

class HomeFragment : BaseMainFragment<FragmentHomeBinding>() {

    private val viewModelF by viewModels<HomeViewModel>()

    private val adapter by lazy {
        ContinentsAdapter().apply {
            listener = object : NationListener {
                override fun onNation(childPosition: Int, nation: Nation) {
                    mainViewModel.setNation(nation)
                    navigateTo(R.id.action_homeFragment_to_nationFragment)
                }
            }
        }
    }

    override fun getLayoutId() = R.layout.fragment_home

    override fun setup() {
        viewModelF.getContinents()
    }

    override fun initBinding() {
        binding.adapter = adapter
    }

    override fun initView() {

    }

    override fun observerViewModel() {
        observer(viewModelF.continents) {
            adapter.submitList(it)
        }
    }
}
