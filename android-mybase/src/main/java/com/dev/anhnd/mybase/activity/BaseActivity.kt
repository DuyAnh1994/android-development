package com.dev.anhnd.mybase.activity

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.InflateException
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.dev.anhnd.mybase.model.IBase

abstract class BaseActivity<DB : ViewDataBinding> : AppCompatActivity(), IBase {

    companion object {
        private val TAG = BaseActivity::class.java.simpleName
    }

    protected lateinit var binding: DB
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        beforeSetup()
        super.onCreate(savedInstanceState)
        try {
            if (fixSingleTask()) {
                if (!isTaskRoot) {
                    finish()
                    return
                }
            }
            binding = DataBindingUtil.setContentView(this, getLayoutId())
            binding.lifecycleOwner = this
            setup()
            observerViewModel()
        } catch (e: InflateException) {
            e.printStackTrace()
            Log.e(TAG, "${e.message}")
        } catch (e: Resources.NotFoundException) {
            e.printStackTrace()
            Log.e(TAG, "${e.message}")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e(TAG, "${e.message}")
        }
    }

    protected open fun fixSingleTask(): Boolean = false


    override fun hideKeyBoard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }

    override fun showKeyBoard(view: View) {

    }

    override fun hideLoading() {

    }

    override fun showLoading() {

    }

    override fun showMessage(message: String) {
        try {
            var toast = Toast(this)
            runOnUiThread {
                toast.cancel()
                toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
                toast.show()
            }
        } catch (e: IllegalStateException) {
            Log.e(TAG, "${e.message}")
        } catch (e: Exception) {
            Log.e(TAG, "${e.message}")
        }
    }

    override fun showMessage(resId: Int) {
        try {
            runOnUiThread {
                Toast.makeText(this, getString(resId), Toast.LENGTH_SHORT).show()
            }
        } catch (e: IllegalStateException) {
            Log.e(TAG, "${e.message}")
        } catch (e: Exception) {
            Log.e(TAG, "${e.message}")
        }
    }
}