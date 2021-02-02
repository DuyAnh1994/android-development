package com.dev.anhnd.mybase.utils.work

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*


private var jobLoading: Job = Job()
private var scopeDoing = CoroutineScope(Dispatchers.IO + jobLoading)
fun <T> doJob(dispatcherIn: CoroutineDispatcher = Dispatchers.IO,
              dispatcherOut: CoroutineDispatcher = Dispatchers.Main,
              delay: Long = 0L,
              doIn: (scopeDoIn: CoroutineScope) -> T,
              doOut: (T) -> Unit) {
    jobLoading = async(dispatcherIn, dispatcherOut, delay, doIn, doOut)
}

fun <T> async(dispatcherIn: CoroutineDispatcher = Dispatchers.IO,
              dispatcherOut: CoroutineDispatcher = Dispatchers.Main,
              delay: Long = 0,
              doIn: (scopeDoIn: CoroutineScope) -> T,
              doOut: (T) -> Unit): Job {
    return scopeDoing.coroutinesDoJob(dispatcherIn, dispatcherOut, delay, doIn, doOut)
}

fun <T> CoroutineScope.coroutinesDoJob(dispatcherIn: CoroutineDispatcher = Dispatchers.IO,
                                       dispatcherOut: CoroutineDispatcher = Dispatchers.Main,
                                       delay: Long = 0,
                                       doIn: (scopeDoIn: CoroutineScope) -> T,
                                       doOut: (T) -> Unit): Job {
    return this.launch(dispatcherIn) {
        val data = doIn.invoke(this)
        delay(delay)
        withContext(dispatcherOut) {
            doOut.invoke(data)
        }
    }
}

fun <T> ViewModel.viewModelDoJob(dispatcherIn: CoroutineDispatcher = Dispatchers.IO,
                                 dispatcherOut: CoroutineDispatcher = Dispatchers.Main,
                                 delay: Long = 0,
                                 doIn: (scopeDoIn: CoroutineScope) -> T,
                                 doOut: (T) -> Unit = {}): Job {
    return viewModelScope.launch(dispatcherIn) {
        val data = doIn.invoke(this)
        delay(delay)
        withContext(dispatcherOut) {
            doOut.invoke(data)
        }
    }
}

fun <T> GlobalScope.globalDoJob(dispatcherIn: CoroutineDispatcher = Dispatchers.IO,
                                dispatcherOut: CoroutineDispatcher = Dispatchers.Main,
                                delay: Long = 0,
                                doIn: (scopeDoIn: CoroutineScope) -> T,
                                doOut: (T) -> Unit): Job {
    return this.launch(dispatcherIn) {
        val data = doIn.invoke(this)
        delay(delay)
        withContext(dispatcherOut) {
            doOut.invoke(data)
        }
    }
}
