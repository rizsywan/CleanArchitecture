package com.example.axa.core.data

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getData(): List<AxaResponse>
}