package com.picpay.desafio.android.data

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiService {

    private var logging: HttpLoggingInterceptor = HttpLoggingInterceptor()
    private val client = OkHttpClient.Builder()

    fun initRetrofit() : Retrofit {

        //configure logging for retrofit 2
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        client.addInterceptor(logging)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()

        val httpClient = getOkHttpClient()
        val gson = getGson()
        val baseUrl = "https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/"
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    private fun getGson(): Gson {
        return GsonBuilder().create()
    }
}