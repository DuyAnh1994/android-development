package com.dev.anhnd.android_web_service.ui.movies

import android.os.Bundle
import android.view.View
import com.dev.anhnd.android_web_service.R
import com.dev.anhnd.android_web_service.databinding.FragmentMovieBinding
import com.dev.anhnd.android_web_service.model.ApiDetail
import com.dev.anhnd.android_web_service.utils.Constant
import com.dev.anhnd.mybase.BaseFragment
import com.dev.anhnd.mybase.utils.app.observer
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragment : BaseFragment<FragmentMovieBinding>() {

    private val viewModelF by viewModel<MovieViewModel>()
    private val adapter by lazy {
        ApiDetailAdapter().apply {
            listener = object : ApiDetailListener {
                override fun onClickItem(position: Int, item: ApiDetail) {
                    getApi(position, item)
                }
            }
        }
    }

    override fun getLayoutId() = R.layout.fragment_movie

    override fun setup(savedInstanceState: Bundle?) {
        viewModelF.getMovieDetail()
    }

    override fun initBinding() {
        binding.adapter = adapter
    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {

    }

    override fun observerViewModel() {
        observer(viewModelF.movieDetail) {
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
            Constant.API_DETAIL_MOVIES_GET_NOW_PLAYING -> {
                viewModelF.getNowPlaying()
            }
            Constant.API_DETAIL_MOVIES_GET_POPULAR -> {
                viewModelF.getPopular()
            }
            Constant.API_DETAIL_MOVIES_GET_TOP_RATED -> {
                viewModelF.getTopRated()
            }
            Constant.API_DETAIL_MOVIES_GET_UPCOMING -> {
                viewModelF.getUpcoming()
            }
        }
    }
}
