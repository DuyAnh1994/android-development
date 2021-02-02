package com.dev.anhnd.android_list_demo.national

import android.os.Bundle
import android.view.View
import com.dev.anhnd.android_list_demo.R
import com.dev.anhnd.android_list_demo.databinding.FragmentNationalBinding
import com.dev.anhnd.android_list_demo.main.MainActivity
import com.dev.anhnd.mybase.BaseFragment
import com.dev.anhnd.mybase.utils.app.observer
import com.dev.anhnd.mybase.utils.log.logd
import org.koin.android.viewmodel.ext.android.viewModel


//@AndroidEntryPoint
class NationalFragment : BaseFragment<FragmentNationalBinding>() {

    //    private val viewModelF by viewModels<NationalViewModel>()
    private val viewModelF: NationalViewModel by viewModel()
    private val adapter by lazy {
        NationalAdapter().apply {
            listener = object : NationalListener {
                override fun onClickItem(position: Int, national: National) {
                    selected(national)
                }

                override fun onLongClickItem(position: Int, national: National): Boolean {
                    remove(national)
                    viewModelF.remove(national)
                    return super.onLongClickItem(position, national)
                }
            }
        }
    }

    override fun getLayoutId() = R.layout.fragment_national

    override fun setup(savedInstanceState: Bundle?) {
        viewModelF.getList()
    }

    override fun initBinding() {
        binding.adapter = adapter
    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {

    }

    override fun observerViewModel() {
        observer(adapter.liveSelected) {
            logd(it.toString())
        }
        observer(viewModelF.liveNationals) {
            adapter.submitList(it?.toMutableList())
        }
    }

    override fun onBackPressed() {
        (activityOwner as MainActivity).finish()
    }
}
