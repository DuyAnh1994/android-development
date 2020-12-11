package com.dev.anhnd.android_mvvm_di.ui.main

import android.util.Log
import android.view.View
import com.dev.anhnd.android_mvvm_di.R
import com.dev.anhnd.android_mvvm_di.databinding.ActivityMainBinding
import com.dev.anhnd.android_mvvm_di.model.User
import com.dev.anhnd.android_mvvm_di.utils.Status
import com.dev.anhnd.mybase.BaseActivity
import com.dev.anhnd.mybase.BaseAdapter
import com.dev.anhnd.mybase.utils.app.observer
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val TAG = MainActivity::class.java.simpleName

    private val adapter by lazy {
        BaseAdapter<User>(R.layout.item_user)
    }
    private val mainVM: MainViewModel by viewModel()


    override fun getLayoutId(): Int = R.layout.activity_main

    override fun setup() {
        binding.rvUser.adapter = adapter
    }

    override fun initView() {
        binding.viewModel = mainVM
    }

    override fun observerViewModel() {
        observer(mainVM.user) {
            it?.let { event ->
                when (event.status) {
                    Status.SUCCESS -> {
                        event.data?.let { user ->
                            adapter.data = user
                        }
                        Log.d(TAG, "SUCCESS")
                    }
                    Status.LOADING -> {
                        Log.d(TAG, "LOADING")
                    }
                    Status.ERROR -> {
                        Log.d(TAG, "ERROR")
                    }
                }
            }
        }
    }
}