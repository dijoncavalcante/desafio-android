package com.picpay.desafio.android.data

sealed class RequestResult<T>(
    val data: T? = null,
    val errorMsg: String? = null
) {
    class Succeeded<T>(data: T) : RequestResult<T>(data)
    class Failure<T>(errorMsg: String, exception: T? = null) : RequestResult<T>(exception, errorMsg)
    object Loading : RequestResult<Nothing>()

}
