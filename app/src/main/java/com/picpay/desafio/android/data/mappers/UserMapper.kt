package com.picpay.desafio.android.data.mappers

import com.picpay.desafio.android.data.model.response.UserResponse
import com.picpay.desafio.android.domain.model.UserResult

fun UserResponse.toDomain() = UserResult(
    img = img,
    name = name,
    id = id,
    username = username
)