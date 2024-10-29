package com.example.axa.core.domain.repository

import com.example.axa.core.data.remote.network.ApiResponse
import com.example.axa.core.domain.model.AxaEntity
import kotlinx.coroutines.flow.Flow

interface IAxaRepository {
    suspend fun getAxaData(): Flow<ApiResponse<List<AxaEntity>>>
}