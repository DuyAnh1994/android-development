package com.dev.anhnd.android_navigation_component.about

import androidx.lifecycle.MutableLiveData
import com.dev.anhnd.android_navigation_component.R
import com.dev.anhnd.android_navigation_component.databinding.FragmentAboutBinding
import com.dev.anhnd.android_navigation_component.main.BaseMainFragment
import com.dev.anhnd.mybase.utils.log.logd
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
@WithFragmentBindings
class AboutFragment : BaseMainFragment<FragmentAboutBinding>() {

    private val TAG = AboutFragment::class.java.simpleName

    private var count = MutableLiveData(0)

    override fun getLayoutId(): Int = R.layout.fragment_about

    override fun setup() {
        logd("setup: ")
    }

    override fun initBinding() {
        binding.mainViewModel = mainViewModel
        binding.count = count
    }

    override fun initView() {

    }

    override fun observerViewModel() {

    }

    override fun onViewClick(viewId: Int) {
        when (viewId) {
            R.id.btnBack -> {
                onBackPressed()
            }
            R.id.btnNext -> {
//                navigateTo(R.id.action_aboutFragment_to_previewFragment)
            }
            R.id.btnCount -> {
                count.value = count.value?.plus(1)
            }
            R.id.btnText -> {
                mainViewModel.liveText.value = count.value.toString()
            }

        }
    }

    override fun onBackPressed() {
        mainViewModel.showMenu()
        backScreen()
    }
}