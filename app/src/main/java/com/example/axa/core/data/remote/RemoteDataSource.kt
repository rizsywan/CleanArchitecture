package com.example.axa.core.data.remote

import com.example.axa.core.data.remote.network.ApiResponse
import com.example.axa.core.data.remote.network.ApiService
import com.example.axa.core.domain.model.AxaEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getAxaData(): Flow<ApiResponse<List<AxaEntity>>> {
        return flow {
            try {
                val response = apiService.getData()
                if (response.isEmpty()) {
                    emit(ApiResponse.Empty)
                } else {
                    emit(ApiResponse.Success(data = response.map { AxaEntity(it.title) }))
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(errorMessage = e.message.toString()))
            }
        }
    }
}