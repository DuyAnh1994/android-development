package com.dev.anhnd.android_mvvm_di.ui.main

import android.view.View
import androidx.activity.viewModels
import com.dev.anhnd.android_mvvm_di.R
import com.dev.anhnd.android_mvvm_di.databinding.ActivityMainBinding
import com.dev.anhnd.android_mvvm_di.model.User
import com.dev.anhnd.android_mvvm_di.utils.Status
import com.dev.anhnd.mybase.activity.BaseActivity
import com.dev.anhnd.mybase.adapter.BaseAdapter
import com.dev.anhnd.mybase.utils.app.observer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {


    private val adapter by lazy {
        BaseAdapter<User>(R.layout.item_user)
    }
    private val mainVM: MainViewModel by viewModels()


    override fun getLayoutId(): Int = R.layout.activity_main

    override fun setup() {
        binding.rvUser.adapter = adapter
    }

    override fun observerViewModel() {
        observer(mainVM.user) {
            it?.let { event ->
                when (event.status) {
                    Status.SUCCESS -> {
                        binding.progress.visibility = View.GONE
                        event.data?.let { user ->
                            adapter.data = user
                        }
                    }
                    Status.LOADING -> {
                        binding.progress.visibility = View.VISIBLE
                    }
                    Status.ERROR -> {
                        binding.progress.visibility = View.GONE
                    }
                }
            }
        }
    }
}