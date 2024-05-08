package com.jennysival.nookapp.utils

sealed class ViewState<out T> {
    data class Success<T>(val data: T) : ViewState<T>()
    data class Error(val throwable: Throwable) : ViewState<Nothing>()
    data class Loading(val loading: Boolean) : ViewState<Nothing>()
}