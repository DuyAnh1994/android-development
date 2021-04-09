package com.dev.anhnd.android_mvvm_di_hilt.ui.notes.add_notes

import androidx.fragment.app.viewModels
import com.dev.anhnd.android_mvvm_di_hilt.R
import com.dev.anhnd.android_mvvm_di_hilt.data.source.local.entity.Notes
import com.dev.anhnd.android_mvvm_di_hilt.databinding.FragmentAddNotesBinding
import com.dev.anhnd.mybase.BaseFragment
import com.dev.anhnd.mybase.utils.input.hideKeyBoard
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
@WithFragmentBindings
class AddNotesFragment : BaseFragment<FragmentAddNotesBinding>() {

    private val viewModel by viewModels<AddNotesViewModel>()
    override fun getLayoutId() = R.layout.fragment_add_notes

    override fun initBinding() {
        binding.viewModel = viewModel
    }

    override fun initView() {

    }

    override fun observerViewModel() {

    }

    override fun onViewClick(viewId: Int) {
        when (viewId) {
            R.id.btnInsert -> {
                viewModel.addNotes(Notes(title = viewModel.liveTextTitle.value!!, content = viewModel.liveTextContent.value!!)) {
                    hideKeyBoard(binding.edtTitle)
                    hideKeyBoard(binding.edtContent)
                    popBackStack(R.id.listNotesFragment)
                }
            }
            R.id.btnCancel -> {
                hideKeyBoard(binding.edtTitle)
                hideKeyBoard(binding.edtContent)
                popBackStack(R.id.listNotesFragment)
            }
        }
    }

    override fun onBackPressed() {
        backScreen()
    }
}
