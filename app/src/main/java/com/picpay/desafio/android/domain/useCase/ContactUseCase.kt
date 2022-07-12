package com.picpay.desafio.android.domain.useCase

import com.picpay.desafio.android.data.RequestResult
import com.picpay.desafio.android.data.model.response.UserResponse

interface ContactUseCase {

    suspend fun getUsers(): RequestResult<List<UserResponse>>

}