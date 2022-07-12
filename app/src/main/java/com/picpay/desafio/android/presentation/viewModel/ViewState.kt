package com.picpay.desafio.android.presentation.viewModel

sealed class ViewState<out T> {
    data class SUCCESS<T> (val data: T?): ViewState<T>()
    object  ERROR: ViewState<Nothing>()
    object LOADING: ViewState<Nothing>()
}