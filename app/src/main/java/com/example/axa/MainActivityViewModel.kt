package com.example.axa

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.axa.core.data.remote.network.ApiResponse
import com.example.axa.core.domain.model.AxaEntity
import com.example.axa.core.domain.usecase.AxaUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val axaUseCase: AxaUseCase): ViewModel() {
    private val _dataFlow = MutableSharedFlow<ApiResponse<List<AxaEntity>>>()
    val dataFlow = _dataFlow.asSharedFlow()

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            _dataFlow.emitAll(
                axaUseCase.getData()
            )
        }
    }
}