package com.example.axa.core.data

import com.example.axa.core.domain.AxaEntity
import com.example.axa.core.domain.IAxaRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AxaRepository: IAxaRepository {
    override suspend fun getAxaData(): List<AxaEntity> {

        return ApiConfig.apiService.getData().map {
            AxaEntity(it.title?:"data tidak ada")
        }
    }
}