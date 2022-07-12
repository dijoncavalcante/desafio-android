package com.picpay.desafio.android.domain.datasource

import com.picpay.desafio.android.data.model.response.UserResponse
import retrofit2.Response

interface ContactDataSource {

    suspend fun getUsers(): Response<List<UserResponse>>

}