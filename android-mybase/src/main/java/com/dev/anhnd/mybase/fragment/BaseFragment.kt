package com.dev.anhnd.mybase.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.dev.anhnd.mybase.activity.BaseActivity
import com.dev.anhnd.mybase.model.IBase

abstract class BaseFragment<DB : ViewDataBinding, A : BaseActivity<ViewDataBinding>> : Fragment(),
    IBase {

    @Suppress("UNCHECKED_CAST")
    val activity by lazy {
        context as A
    }

    protected lateinit var binding: DB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        beforeSetup()
        super.onViewCreated(view, savedInstanceState)
        setup()
        observerViewModel()
    }

    open fun onBackScreen() {
        navigateUp()
    }

    private fun navigateUp() {
        try {
            findNavController().navigateUp()
        } catch (e: IllegalArgumentException) {

        } catch (e: Exception) {

        }
    }

    fun navigateTo(actionId: Int, args: Bundle? = null) {
        try {
            with(findNavController()) {
                currentDestination?.getAction(actionId)?.let {
                    if (currentDestination?.id != currentDestination?.getAction(actionId)?.destinationId) {
                        navigate(actionId, args)
                    }
                }
            }
        } catch (e: IllegalArgumentException) {

        } catch (e: Exception) {

        }
    }

    fun popBackStack(tag: String) {
        val backTag = if (tag.isEmpty()) javaClass.simpleName else tag
        activity.supportFragmentManager.popBackStack(
            backTag,
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
    }

    override fun hideKeyBoard() {
        activity.hideKeyBoard()
    }

    override fun showKeyBoard(view: View) {
        activity.showKeyBoard(view)
    }

    override fun hideLoading() {
        activity.hideLoading()
    }

    override fun showLoading() {
        activity.showLoading()
    }

    override fun showMessage(message: String) {
        activity.showMessage(message)
    }

    override fun showMessage(resId: Int) {
        activity.showMessage(resId)
    }
}