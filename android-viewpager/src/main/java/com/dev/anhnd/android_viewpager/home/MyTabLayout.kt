package com.dev.anhnd.android_viewpager.home

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.widget.TextView
import com.dev.anhnd.android_viewpager.R
import com.google.android.material.tabs.TabLayout

class MyTabLayout @JvmOverloads constructor(
    ctx: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : TabLayout(ctx, attrs, defStyle) {


    override fun newTab(): Tab {
        val tab = super.newTab()
        tab.setCustomView(R.layout.layout_custom_tab_layout)
        setTabTextColor(tab, tabTextColors)
        return tab
    }

    override fun setTabTextColors(textColor: ColorStateList?) {
        super.setTabTextColors(textColor)
        for (index in 0..tabCount) {
            setTabTextColor(getTabAt(index), textColor)
        }
    }

    private fun setTabTextColor(tab: Tab?, textColors: ColorStateList?) {
        val textView = tab?.customView?.findViewById<TextView>(android.R.id.text1)
        textView?.apply {
            setTextColor(textColors)
        }
    }
}
