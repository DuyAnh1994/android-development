package com.dev.anhnd.android_nested_recycleview.ui.home

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.dev.anhnd.android_nested_recycleview.R
import com.dev.anhnd.android_nested_recycleview.databinding.FragmentHomeBinding
import com.dev.anhnd.android_nested_recycleview.model.Nation
import com.dev.anhnd.android_nested_recycleview.ui.main.BaseMainFragment
import com.dev.anhnd.mybase.utils.app.observer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseMainFragment<FragmentHomeBinding>() {

    private val TAG = HomeFragment::class.java.simpleName
    private val viewModelF by viewModels<HomeViewModel>()

    private val adapter by lazy {
        ContinentsAdapter().apply {
            listener = object : NationListener {
                override fun onNation(childPosition: Int, nation: Nation) {
                    /*transitionTo(
                        NationFragment(),
                        R.anim.slide_enter_left_to_right,
                        R.anim.slide_exit_right_to_left,
                        R.anim.slide_pop_enter_right_to_left,
                        R.anim.slide_pop_exit_left_to_right,
                    )*/



                    mainViewModel.setNation(nation)
                    navigateTo(R.id.action_homeFragment_to_nationDialog)
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
        observer(viewModelF.liveState) {

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        viewModelF.saveState()
        super.onSaveInstanceState(outState)
    }
}
