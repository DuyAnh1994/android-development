package com.dev.anhnd.android_navigation_component.language

import androidx.fragment.app.activityViewModels
import com.dev.anhnd.android_navigation_component.R
import com.dev.anhnd.android_navigation_component.databinding.FragmentLanguageBinding
import com.dev.anhnd.android_navigation_component.main.BaseMainFragment
import com.dev.anhnd.android_navigation_component.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
@WithFragmentBindings
class LanguageFragment : BaseMainFragment<FragmentLanguageBinding>() {

    private val TAG = LanguageFragment::class.java.simpleName

    override fun getLayoutId(): Int = R.layout.fragment_language

    override fun setup() {

    }

    override fun initBinding() {
        binding.mainViewModel = mainViewModel
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
        }
    }

    override fun onBackPressed() {
        backScreen()
    }
}