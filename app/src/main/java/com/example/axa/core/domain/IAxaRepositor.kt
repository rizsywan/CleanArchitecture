package com.example.axa.core.domain

interface IAxaRepository {
    suspend fun getAxaData(): List<AxaEntity>
}