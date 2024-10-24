package com.example.axa

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.axa.core.data.AxaRepository
import com.example.axa.core.domain.AxaEntity
import kotlinx.coroutines.launch

class MainActivityViewModel(private val axaRepository: AxaRepository): ViewModel() {
    private val _data = MutableLiveData<List<AxaEntity>>()
    val data: LiveData<List<AxaEntity>> get() = _data

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            _data.value = axaRepository.getAxaData()
        }
    }
}