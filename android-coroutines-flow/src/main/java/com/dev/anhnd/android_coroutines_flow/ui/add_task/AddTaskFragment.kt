package com.dev.anhnd.android_coroutines_flow.ui.add_task

import com.dev.anhnd.android_coroutines_flow.R
import com.dev.anhnd.android_coroutines_flow.databinding.FragmentAddTaskBinding
import com.dev.anhnd.mybase.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddTaskFragment : BaseFragment<FragmentAddTaskBinding>() {


    override fun getLayoutId() = R.layout.fragment_add_task

    override fun setup() {

    }

    override fun initBinding() {

    }

    override fun initView() {

    }

    override fun observerViewModel() {

    }

    override fun onViewClick(viewId: Int) {
        when (viewId) {
            R.id.btnDone -> {
                popBackStack(R.id.taskFragment)
            }
        }
    }
}
