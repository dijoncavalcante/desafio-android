package com.picpay.desafio.android.data.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserResponse(
    @SerializedName("img")
    val img: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("username")
    val username: String? = null
)