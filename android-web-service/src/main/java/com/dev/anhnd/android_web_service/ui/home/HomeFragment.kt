package com.dev.anhnd.android_web_service.ui.home

import android.os.Bundle
import android.view.View
import com.dev.anhnd.android_web_service.R
import com.dev.anhnd.android_web_service.databinding.FragmentHomeBinding
import com.dev.anhnd.android_web_service.model.ApiType
import com.dev.anhnd.android_web_service.utils.Constant
import com.dev.anhnd.mybase.BaseFragment
import com.dev.anhnd.mybase.utils.app.observer
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    //    private val viewModelF by viewModels<HomeViewModel>()
    private val viewModelF by viewModel<HomeViewModel>()

    private val adapter by lazy {
        ApiTypeAdapter().apply {
            listener = object : ApiTypeListener {
                override fun onClickItem(position: Int, item: ApiType) {
                    navigateTo(position, item)
                }
            }
        }
    }

    override fun getLayoutId() = R.layout.fragment_home

    override fun setup(savedInstanceState: Bundle?) {
        viewModelF.getApiTypes()
    }

    override fun initBinding() {
        binding.adapter = adapter
    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {

    }

    override fun observerViewModel() {
        observer(viewModelF.apiType) {
            adapter.submitList(it)
        }
    }

    override fun onViewClick(viewId: Int) {

    }

    override fun onBackPressed() {

    }

    private fun navigateTo(position: Int, item: ApiType) {
        when (item.name) {
            Constant.API_TYPE_ACCOUNT -> {
            }
            Constant.API_TYPE_AUTHENTICATION -> {
            }
            Constant.API_TYPE_CERTIFICATIONS -> {
            }
            Constant.API_TYPE_CHANGES -> {
            }
            Constant.API_TYPE_COMPANIES -> {
            }
            Constant.API_TYPE_CONFIGURATION -> {
            }
            Constant.API_TYPE_CREDITS -> {
            }
            Constant.API_TYPE_DISCOVER -> {
            }
            Constant.API_TYPE_FIND -> {
            }
            Constant.API_TYPE_GENRES -> {
            }
            Constant.API_TYPE_GUEST_SESSION -> {
            }
            Constant.API_TYPE_KEYWORDS -> {
            }
            Constant.API_TYPE_LISTS -> {
            }
            Constant.API_TYPE_MOVIES -> {
                navigateTo(R.id.action_homeFragment_to_movieFramgnet)
            }
            Constant.API_TYPE_NETWORKS -> {
            }
            Constant.API_TYPE_TRENDING -> {
            }
            Constant.API_TYPE_PEOPLE -> {
                navigateTo(R.id.action_homeFragment_to_peopleFragment)
            }
            Constant.API_TYPE_REVIEWS -> {
            }
            Constant.API_TYPE_SEARCH -> {
            }
            Constant.API_TYPE_TV -> {
            }
            Constant.API_TYPE_TV_SEASON -> {
            }
            Constant.API_TYPE_TV_EPISODES -> {
            }
            Constant.API_TYPE_TV_EPISODE_GROUP -> {
            }
        }
    }
}
