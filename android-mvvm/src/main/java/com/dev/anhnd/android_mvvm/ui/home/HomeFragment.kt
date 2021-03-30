package com.dev.anhnd.android_mvvm.ui.home

import android.view.View
import androidx.fragment.app.viewModels
import com.dev.anhnd.android_mvvm.R
import com.dev.anhnd.android_mvvm.databinding.FragmentHomeBinding
import com.dev.anhnd.android_mvvm.ui.dialog.DeleteDialog
import com.dev.anhnd.android_mvvm.ui.dialog.SaveDialog
import com.dev.anhnd.android_mvvm.ui.main.ItemNewsListener
import com.dev.anhnd.mybase.BaseFragment
import com.dev.anhnd.mybase.utils.adapter.BaseMultiHolderAdapter
import com.dev.anhnd.mybase.utils.app.observer
import com.dev.anhnd.mybase.utils.log.logd

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModelF by viewModels<HomeViewModel>()

    private val dialogDelete by lazy {
        DeleteDialog()
    }

    private val dialogSave by lazy {
        SaveDialog()
    }

    //region single holder adapter
    private val adapter by lazy {
        PhotosAdapter()
    }
    //endregion

    //region multi holder adapter
    private val adapterMulti by lazy {
        NewsAdapter().apply {
            listener = object : ItemNewsListener {
                override fun onItemClick(v: View, item: BaseMultiHolderAdapter.BaseModelType, position: Int) {
                    logd("position: $position ,  type${item.viewType}")
                }
            }
        }
    }
    //endregion

    override fun getLayoutId() = R.layout.fragment_home

    override fun setup() {
//        viewModel.getPhotos()
        viewModelF.getNews()
    }

    override fun initBinding() {
        binding.adapter = adapter
        binding.adapterMulti = adapterMulti
    }

    override fun initView() {
    }

    override fun observerViewModel() {
//        observer(viewModelF.photos) {
//            adapter.submitList(it?.toMutableList())
//        }

        observer(viewModelF.news) {
            adapterMulti.submitList(it)
        }
    }

    override fun onViewClick(viewId: Int) {
        when (viewId) {
            R.id.constraintRoot -> {
//                dialogDelete.showDialog(fm = childFragmentManager, tag = DeleteDialog::class.java.simpleName)
//                dialogSave.showDialog(childFragmentManager, SaveDialog::class.java.simpleName)
            }
        }
    }
}