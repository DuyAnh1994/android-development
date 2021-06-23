package com.dev.anhnd.android_nested_recycleview.ui.home

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.dev.anhnd.android_nested_recycleview.R
import com.dev.anhnd.android_nested_recycleview.databinding.FragmentHomeBinding
import com.dev.anhnd.android_nested_recycleview.model.Nation
import com.dev.anhnd.android_nested_recycleview.ui.main.BaseMainFragment
import com.dev.anhnd.android_nested_recycleview.utils.MessageEvent
import com.dev.anhnd.mybase.utils.app.observer
import dagger.hilt.android.AndroidEntryPoint
import org.greenrobot.eventbus.EventBus

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
//                    mainViewModel.setNation(nation)
                    val obj = MessageEvent().apply {
                        data = nation
                    }
                    EventBus.getDefault().postSticky(obj)
                    val map = mutableMapOf<String, String>()
                    val bundle = bundleOf("key" to map)
                    navigateTo(R.id.action_homeFragment_to_nationFragment, bundle)
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
