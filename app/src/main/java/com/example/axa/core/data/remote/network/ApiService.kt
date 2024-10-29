package com.example.axa.core.data.remote.network

import com.example.axa.core.data.remote.response.AxaResponse
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getData(): List<AxaResponse>
}