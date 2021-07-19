package com.bishop.requestingapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestProvider {
    private val retrofit = Retrofit.Builder().baseUrl("https://ict-yep-backend.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    val apiRequests = retrofit.create(ApiRequests::class.java)
}