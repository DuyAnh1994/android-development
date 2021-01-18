package com.dev.anhnd.android_mvvm.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.dev.anhnd.android_mvvm.R
import com.dev.anhnd.android_mvvm.databinding.ActivityMainBinding
import com.dev.anhnd.android_mvvm.model.News
import com.dev.anhnd.android_mvvm.model.User
import com.dev.anhnd.android_mvvm.ui.home.HomeFragment
import com.dev.anhnd.android_mvvm.utils.DataUtils
import com.dev.anhnd.android_mvvm.utils.InjectorUtils
import com.dev.anhnd.mybase.BaseActivity
import com.dev.anhnd.mybase.BaseAdapter
import com.dev.anhnd.mybase.BaseMultiHolderAdapter

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val TAG = MainActivity::class.java.simpleName

    private val mainViewModel: MainViewModel by viewModels {
        InjectorUtils.providerMainViewModelFactory()
    }
    private val adapter by lazy {
        BaseAdapter<User>(R.layout.item_user)
    }

    private val adapterMulti by lazy {
        BaseMultiHolderAdapter<News>(
            R.layout.item_first,
            R.layout.item_second,
            R.layout.item_third).apply {
            listener = object : ItemNewsListener {
                override fun onItemClick(v: View, item: News, position: Int) {
                    Log.d(TAG, "item = ${item}, position = $position")
                }
            }
        }
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun setup(savedInstanceState: Bundle?) {
//        mainViewModel.fetchUsers()
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun initView(view: View?, savedInstanceState: Bundle?) {
//        binding.rvUser.adapter = adapter
        /*CoroutineScope(Dispatchers.IO).launch {
            val result = MediaUtils.getAllMedia(t = BaseImage())
            result?.forEach {
                Log.d(TAG, "initView: $it")
            }
        }*/
        supportFragmentManager.beginTransaction()
            .add(R.id.constraintRoot, HomeFragment(), HomeFragment::class.java.simpleName)
            .addToBackStack( HomeFragment::class.java.simpleName)
            .commit()

//        binding.rvDemo.adapter = adapterMulti
//        adapterMulti.data = DataUtils.news()

    }

    override fun observerViewModel() {
//        observer(mainViewModel.users) {
//            it?.let { users ->
//                adapter.data = users
//            }
//        }
    }
}

