package com.dev.anhnd.android_multi_viewholder_recyelview.app

import com.dev.anhnd.android_multi_viewholder_recyelview.R
import com.dev.anhnd.android_multi_viewholder_recyelview.app.adapter.TimelineAdapter
import com.dev.anhnd.android_multi_viewholder_recyelview.app.model.Info
import com.dev.anhnd.android_multi_viewholder_recyelview.app.model.News
import com.dev.anhnd.android_multi_viewholder_recyelview.databinding.ActivityMainBinding
import com.dev.anhnd.mybase.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val timelineAdapter by lazy {
        TimelineAdapter().apply {

        }
    }

    override fun getLayoutId() = R.layout.activity_main


    override fun initBinding() {
        binding.adapter = timelineAdapter
    }

    override fun initView() {
        // info
        val info = Info(R.drawable.ic_person, 48, 186, 406)
        timelineAdapter.setInfo(info)

        // news
        val news = mutableListOf(
            News(R.drawable.ic_nation_canada),
            News(R.drawable.ic_nation_south_korea),
            News(R.drawable.ic_nation_italy)
        )

        timelineAdapter.setNews(news)
    }

    override fun observerViewModel() {

    }

}