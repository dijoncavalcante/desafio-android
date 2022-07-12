package com.picpay.desafio.android.domain.useCase

import com.picpay.desafio.android.data.RequestResult
import com.picpay.desafio.android.data.model.response.UserResponse
import com.picpay.desafio.android.domain.repository.ContactRepository

class ContactUseCaseImpl(
    private val repository: ContactRepository
) : ContactUseCase {
    override suspend fun getUsers(): RequestResult<List<UserResponse>> {
        return repository.getUsers()
    }
}