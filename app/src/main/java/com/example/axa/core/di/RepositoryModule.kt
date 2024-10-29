package com.example.axa.core.di

import com.example.axa.core.data.AxaRepository
import com.example.axa.core.domain.repository.IAxaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(repository: AxaRepository): IAxaRepository
}