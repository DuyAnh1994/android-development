package com.dev.anhnd.android_mvvm_di.utils

data class Event<out T>(
    val status: Status,
    val data: T?,
    val message: String?
) {
    companion object {

        fun <T> success(data: T?): Event<T> {
            return Event(Status.SUCCESS, data, null)
        }

        fun <T> error(data: T?, msg: String): Event<T> {
            return Event(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): Event<T> {
            return Event(Status.LOADING, data, null)
        }
    }
}