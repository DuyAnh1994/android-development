package com.dev.anhnd.android_web_service.ui.people

import android.os.Bundle
import com.dev.anhnd.android_web_service.R
import com.dev.anhnd.android_web_service.databinding.FragmentPeopleBinding
import com.dev.anhnd.android_web_service.data.model.ApiDetail
import com.dev.anhnd.android_web_service.ui.movies.ApiDetailAdapter
import com.dev.anhnd.android_web_service.ui.movies.ApiDetailListener
import com.dev.anhnd.android_web_service.utils.Constant
import com.dev.anhnd.mybase.BaseFragment
import com.dev.anhnd.mybase.utils.app.observer
import org.koin.androidx.viewmodel.ext.android.viewModel

class PeopleFragment : BaseFragment<FragmentPeopleBinding>() {

    private val viewModelF by viewModel<PeopleViewModel>()
    private val adapter by lazy {
        ApiDetailAdapter().apply {
            listener = object : ApiDetailListener {
                override fun onClickItem(position: Int, item: ApiDetail) {
                    getApi(position, item)
                }
            }
        }
    }

    override fun getLayoutId() = R.layout.fragment_people

    override fun setup() {
        viewModelF.getMovieDetail()
    }

    override fun initBinding() {
        binding.adapter = adapter
    }

    override fun initView() {

    }

    override fun observerViewModel() {
        observer(viewModelF.peopleDetail) {
            adapter.submitList(it)
        }

    }

    override fun onViewClick(viewId: Int) {

    }

    override fun onBackPressed() {
        backScreen()
    }

    private fun getApi(position: Int, item: ApiDetail) {
        when (item.name) {
            Constant.API_DETAIL_PEOPLE_GET_POPULAR -> {
                viewModelF.getPopular()
            }
        }
    }
}
