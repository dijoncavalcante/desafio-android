package com.picpay.desafio.android.data.repository

import com.picpay.desafio.android.data.BaseApiResponse
import com.picpay.desafio.android.data.RequestResult
import com.picpay.desafio.android.data.model.response.UserResponse
import com.picpay.desafio.android.domain.datasource.ContactDataSource
import com.picpay.desafio.android.domain.repository.ContactRepository

class ContactRepositoryImpl(
    private val dataSource: ContactDataSource
) : ContactRepository, BaseApiResponse() {
    override suspend fun getUsers(): RequestResult<List<UserResponse>> {
        val responseList = dataSource.getUsers()
        return safeApiCall { responseList }
    }
}