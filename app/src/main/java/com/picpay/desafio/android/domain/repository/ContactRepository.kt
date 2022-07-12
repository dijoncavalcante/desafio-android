package com.picpay.desafio.android.domain.repository

import com.picpay.desafio.android.data.RequestResult
import com.picpay.desafio.android.data.model.response.UserResponse

interface ContactRepository {

    suspend fun getUsers(): RequestResult<List<UserResponse>>

}