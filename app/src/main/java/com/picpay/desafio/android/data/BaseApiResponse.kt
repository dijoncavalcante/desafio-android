package com.picpay.desafio.android.data

import android.util.Log
import retrofit2.Response

abstract class BaseApiResponse() {

    private val TAG = this.javaClass.name

    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): RequestResult<T> {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    Log.d(TAG, "Request successfully")
                    Log.d(TAG, "Body: $it")
                    return RequestResult.Succeeded(body)
                }
            }
            Log.d(TAG, "Request fail")
            return error("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(errorMessage: String): RequestResult<T> =
        RequestResult.Failure("Api call failed $errorMessage")

}

