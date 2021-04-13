package com.dev.anhnd.android_navigation_component.preview

import androidx.fragment.app.activityViewModels
import com.dev.anhnd.android_navigation_component.R
import com.dev.anhnd.android_navigation_component.databinding.FragmentPreviewBinding
import com.dev.anhnd.android_navigation_component.main.BaseMainFragment
import com.dev.anhnd.android_navigation_component.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
@WithFragmentBindings
class PreviewFragment : BaseMainFragment<FragmentPreviewBinding>() {

    private val TAG = PreviewFragment::class.java.simpleName

    override fun getLayoutId(): Int = R.layout.fragment_preview

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
            R.id.btnNext -> {
//                navigateTo(R.id.action_previewFragment_to_languageFragment)
            }
        }
    }

    override fun onBackPressed() {
        backScreen()
    }
}