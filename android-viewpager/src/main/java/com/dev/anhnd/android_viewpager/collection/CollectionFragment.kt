package com.dev.anhnd.android_viewpager.collection

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import com.dev.anhnd.android_viewpager.R
import com.dev.anhnd.android_viewpager.databinding.FragmentCollectionBinding
import com.dev.anhnd.android_viewpager.main.MainViewModel
import com.dev.anhnd.android_viewpager.model.Student
import com.dev.anhnd.mybase.BaseFragment

class CollectionFragment : BaseFragment<FragmentCollectionBinding>() {

    private val TAG = CollectionFragment::class.java.simpleName
    private val mainViewModel by activityViewModels<MainViewModel>()
    private val adapter by lazy {
//        BaseAdapter<Student>(R.layout.item_student).apply {
//            listener = object : CollectionListener {
//                override fun onClickItem(position: Int) {
//                    if (position % 2 == 0) {
//                        (parentFragment as HomeFragment).getViewPager().currentItem = 2
//                    } else {
//                        (parentFragment as HomeFragment).getViewPager().currentItem = 0
//                    }
//                }
//            }
//        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_collection

    override fun setup() {

    }

    override fun initBinding() {
        binding.mainViewModel = mainViewModel
//        binding.adapter = adapter
    }

    override fun initView() {
        val students = arrayListOf<Student>()
        for (i in 0..20) {
            students.add(Student("Student $i"))
        }
//        adapter.data = students
    }

    override fun observerViewModel() {
    }

    override fun onViewClick(viewId: Int) {
        when (viewId) {
            R.id.tvContent -> {
                navigateTo(R.id.action_homeFragment_to_previewFragment)
            }
        }
    }
}