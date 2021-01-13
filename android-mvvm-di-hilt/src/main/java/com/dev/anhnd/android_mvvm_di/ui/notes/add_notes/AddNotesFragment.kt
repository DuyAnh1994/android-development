package com.dev.anhnd.android_mvvm_di.ui.notes.add_notes

import androidx.fragment.app.viewModels
import com.dev.anhnd.android_mvvm_di.R
import com.dev.anhnd.android_mvvm_di.data.local.notes.Notes
import com.dev.anhnd.android_mvvm_di.databinding.FragmentAddNotesBinding
import com.dev.anhnd.android_mvvm_di.ui.main.MainActivity
import com.dev.anhnd.mybase.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNotesFragment() : BaseFragment<FragmentAddNotesBinding, MainActivity>() {

    private val TAG = AddNotesFragment::class.java.simpleName
    private val viewModel by viewModels<AddNotesViewModel>()
    override fun getLayoutId() = R.layout.fragment_add_notes

    override fun initBinding() {
        binding.viewModel = viewModel
    }

    override fun initView() {

    }

    override fun observerViewModel() {

    }

    override fun onViewClick(ViewId: Int) {
        when (ViewId) {
            R.id.btnInsert -> {
                viewModel.addNotes(Notes(title = viewModel.liveTextTitle.value!!, content = viewModel.liveTextContent.value!!)) {
                    popBackStack(R.id.listNotesFragment)
                }
            }
            R.id.btnCancel -> {
                popBackStack(R.id.listNotesFragment)
            }
        }
    }

    override fun onBackPressed() {
        backScreen()
    }
}
