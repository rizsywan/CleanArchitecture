package com.example.axa.core.data

import com.example.axa.core.data.remote.RemoteDataSource
import com.example.axa.core.data.remote.network.ApiResponse
import com.example.axa.core.domain.model.AxaEntity
import com.example.axa.core.domain.repository.IAxaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AxaRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
): IAxaRepository {
    override suspend fun getAxaData(): Flow<ApiResponse<List<AxaEntity>>>{
        return remoteDataSource.getAxaData()
    }
}