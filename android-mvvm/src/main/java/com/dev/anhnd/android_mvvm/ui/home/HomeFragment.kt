package com.dev.anhnd.android_mvvm.ui.home

import android.os.Bundle
import android.view.View
import com.dev.anhnd.android_mvvm.R
import com.dev.anhnd.android_mvvm.databinding.FragmentHomeBinding
import com.dev.anhnd.android_mvvm.ui.dialog.DeleteDialog
import com.dev.anhnd.android_mvvm.ui.dialog.SaveDialog
import com.dev.anhnd.android_mvvm.ui.main.MainActivity
import com.dev.anhnd.mybase.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, MainActivity>() {

    private val dialogDelete by lazy {
        DeleteDialog()
    }

    private val dialogSave by lazy {
        SaveDialog()
    }

    override fun getLayoutId() = R.layout.fragment_home

    override fun setup(savedInstanceState: Bundle?) {
    }

    override fun initView(view: View?, savedInstanceState: Bundle?) {

    }

    override fun observerViewModel() {
    }

    override fun onViewClick(viewId: Int) {
        when (viewId) {
            R.id.constraintRoot -> {
//                dialogDelete.showDialog(fm = childFragmentManager, tag = DeleteDialog::class.java.simpleName)
                dialogSave.showDialog(childFragmentManager, SaveDialog::class.java.simpleName)
            }
        }
    }
}