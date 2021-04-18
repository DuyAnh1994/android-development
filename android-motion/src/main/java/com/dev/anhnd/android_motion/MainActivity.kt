package com.dev.anhnd.android_motion

import android.view.View
import androidx.constraintlayout.helper.widget.Carousel
import com.dev.anhnd.android_coordinator.R
import com.dev.anhnd.android_coordinator.databinding.ActivityMainBinding
import com.dev.anhnd.mybase.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {


    override fun getLayoutId() = R.layout.activity_main


    override fun initBinding() {

    }

    override fun initView() {
        /*binding.carousel.setAdapter(object : Carousel.Adapter {
            override fun count(): Int {
                return 5
            }

            override fun populate(view: View?, index: Int) {
                TODO("Not yet implemented")
            }

            override fun onNewItem(index: Int) {
                TODO("Not yet implemented")
            }
        })*/
    }

    override fun observerViewModel() {

    }

    override fun onViewClick(viewId: Int) {
        when (viewId) {

        }
    }


}