package com.dev.anhnd.android_mvvm.utils

import com.dev.anhnd.android_mvvm.R
import com.dev.anhnd.android_mvvm.model.News

object DataUtils {

    private val colors = mutableListOf<Int>(
        R.color.colorPickerSupernova,
        R.color.colorPickerAzureRadiance,
        R.color.colorPickerCoralRed,
        R.color.colorPickerViola,
        R.color.colorPickerMalachite,
        R.color.colorPickerCrusta,
        R.color.colorPickerTonysPink,
        R.color.colorPickerElectricViolet,
        R.color.colorPickerBrightTurquoise,
        R.color.colorPickerHotPink,
        R.color.colorPickerVictoria,
    )

    fun news(): List<News> {
        val news = mutableListOf<News>()
        var colorIndex = 0
        for (i in 0..9) {
            when {
                ((i % 2) == 0) -> {
                    news.add(News(viewType = 0, content = "content $i"))
                }
                ((i % 3) == 0) -> {
                    news.add(News(viewType = 2, image = R.drawable.ic_launcher_background))
                }
                else -> {
                    news.add(News(viewType = 1, color = colors[colorIndex]))
                    colorIndex++
                }
            }
        }
        return news
    }
}