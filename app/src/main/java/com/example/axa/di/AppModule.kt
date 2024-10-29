package com.example.axa.di

import com.example.axa.core.domain.usecase.AxaUseCase
import com.example.axa.core.domain.usecase.AxaUseCaseInteractor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideAxaUseCase(axaUseCaseInteractor: AxaUseCaseInteractor): AxaUseCase
}