package com.dev.anhnd.android_mvvm.ui.main

import android.util.Log
import androidx.activity.viewModels
import com.dev.anhnd.android_mvvm.R
import com.dev.anhnd.android_mvvm.databinding.ActivityMainBinding
import com.dev.anhnd.android_mvvm.model.User
import com.dev.anhnd.android_mvvm.utils.InjectorUtils
import com.dev.anhnd.mybase.activity.BaseActivity
import com.dev.anhnd.mybase.adapter.BaseAdapter
import com.dev.anhnd.mybase.utils.app.observer

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val TAG = MainActivity::class.java.simpleName

    private val mainViewModel: MainViewModel by viewModels {
        InjectorUtils.providerMainViewModelFactory()
    }
    private val adapter by lazy {
        BaseAdapter<User>(R.layout.item_user)
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun setup() {
        binding.rvUser.adapter = adapter
        mainViewModel.fetchUsers()
    }

    override fun observerViewModel() {
        observer(mainViewModel.users) {
            it?.let { users ->
                adapter.data = users
            }
        }
    }
}