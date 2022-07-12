package com.picpay.desafio.android.data.datasource

import com.picpay.desafio.android.data.model.response.UserResponse
import com.picpay.desafio.android.data.service.PicPayService
import com.picpay.desafio.android.domain.datasource.ContactDataSource
import retrofit2.Response

class ContactDataSourceImpl(
    private val service: PicPayService
) : ContactDataSource {

    override suspend fun getUsers(): Response<List<UserResponse>> {
        return service.getUsers()
    }

}