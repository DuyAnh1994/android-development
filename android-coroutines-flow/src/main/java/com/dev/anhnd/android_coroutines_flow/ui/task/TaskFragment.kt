package com.dev.anhnd.android_coroutines_flow.ui.task

import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.dev.anhnd.android_coroutines_flow.R
import com.dev.anhnd.android_coroutines_flow.data.local.Task
import com.dev.anhnd.android_coroutines_flow.databinding.FragmentTaskBinding
import com.dev.anhnd.android_coroutines_flow.ui.main.MainActivity
import com.dev.anhnd.mybase.BaseFragment
import com.dev.anhnd.mybase.utils.app.observer
import com.dev.anhnd.mybase.utils.log.logd
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TaskFragment : BaseFragment<FragmentTaskBinding>() {

//    private val viewModelF by viewModels<TaskViewModel>()
    private val adapter by lazy {
        TaskAdapter().apply {
            listener = object : TaskListener {
                override fun onClickItem(position: Int, task: Task) {
//                    logd("#$position,\t$task")
//                    val temp = task.copy()
//                    temp.completed = !temp.completed
//                    viewModelF.update(temp)
                }

                override fun onLongLickItem(position: Int, task: Task): Boolean {
//                    logd("#$position,\t$task")
//                    viewModelF.delete(task)
                    return true
                }
            }
        }
    }

    override fun getLayoutId() = R.layout.fragment_task

    override fun setup(savedInstanceState: Bundle?) {

    }

    override fun initBinding() {
//        binding.viewModelF = viewModelF
        binding.adapter = adapter
    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {
        viewLifecycleOwner.lifecycleScope.launch {

        }
        binding.cbHideCompleted.setOnCheckedChangeListener { buttonView, isChecked ->
//            viewModelF.liveHideCompleted.value= isChecked
        }
    }

    override fun observerViewModel() {
//        observer(viewModelF.tasks) {
//            adapter.submitList(it?.toMutableList())
//        }
    }

    override fun onViewClick(viewId: Int) {
        when (viewId) {
            R.id.btnAddTask -> {

                navigateTo(R.id.action_taskFragment_to_addTaskFragment)
            }
            R.id.btnSort -> {
//                if (viewModelF.liveSortOrder.value == SortOrder.BY_NAME) {
//                    viewModelF.onSortOrderSelected(SortOrder.BY_DATE)
//                } else {
//                    viewModelF.onSortOrderSelected(SortOrder.BY_NAME)
//                }
            }
//            R.id.btnHideCompleted -> {
//                viewModelF.liveHideCompleted.value = !viewModelF.liveHideCompleted.value!!
//                viewModelF.onHideCompletedClick(viewModelF.liveHideCompleted.value!!)
//            }
        }
    }
}
