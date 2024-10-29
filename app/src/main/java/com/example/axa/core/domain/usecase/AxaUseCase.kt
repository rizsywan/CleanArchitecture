package com.example.axa.core.domain.usecase

import com.example.axa.core.data.remote.network.ApiResponse
import com.example.axa.core.domain.model.AxaEntity
import kotlinx.coroutines.flow.Flow

interface AxaUseCase {
    suspend fun getData(): Flow<ApiResponse<List<AxaEntity>>>
}