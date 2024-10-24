package com.example.axa

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.axa.core.data.AxaRepository

class AxaViewModelFactory(private val axaRepository: AxaRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainActivityViewModel(axaRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}