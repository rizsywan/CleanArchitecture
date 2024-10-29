package com.example.axa.core.domain.usecase

import com.example.axa.core.data.remote.network.ApiResponse
import com.example.axa.core.domain.model.AxaEntity
import com.example.axa.core.domain.repository.IAxaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AxaUseCaseInteractor @Inject constructor(private val repository: IAxaRepository): AxaUseCase {
    override suspend fun getData(): Flow<ApiResponse<List<AxaEntity>>> {
        return repository.getAxaData()
    }
}