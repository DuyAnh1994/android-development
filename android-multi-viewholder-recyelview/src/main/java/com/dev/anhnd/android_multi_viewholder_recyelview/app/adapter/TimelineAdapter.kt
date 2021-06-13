package com.dev.anhnd.android_multi_viewholder_recyelview.app.adapter

import com.dev.anhnd.android_multi_viewholder_recyelview.app.binder.InfoBinder
import com.dev.anhnd.android_multi_viewholder_recyelview.app.binder.NewsBinder
import com.dev.anhnd.android_multi_viewholder_recyelview.app.model.Info
import com.dev.anhnd.android_multi_viewholder_recyelview.app.model.News
import com.dev.anhnd.android_multi_viewholder_recyelview.lib.EnumMapBindAdapter

class TimelineAdapter : EnumMapBindAdapter<TimelineAdapter.TimelineViewType>() {

    init {
        putBinder(TimelineViewType.INFO, InfoBinder(this))
        putBinder(TimelineViewType.NEWS, NewsBinder(this))
    }

    override fun getEnumFromPosition(position: Int): TimelineViewType {
        return when (position) {
            0 -> {
                TimelineViewType.INFO
            }
            else -> {
                TimelineViewType.NEWS
            }
        }
    }

    override fun getEnumFromOrdinal(ordinal: Int) = TimelineViewType.values()[ordinal]

    fun setInfo(info: Info) {
        (getDataBinder(TimelineViewType.INFO) as InfoBinder).data = info
    }

    fun setNews(news: List<News>) {
        (getDataBinder(TimelineViewType.NEWS) as NewsBinder).data = news
    }

    enum class TimelineViewType {
        INFO, NEWS
    }
}
