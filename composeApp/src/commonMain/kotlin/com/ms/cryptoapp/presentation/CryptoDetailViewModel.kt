package com.ms.cryptoapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ms.cryptoapp.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CryptoDetailViewModel(private val cryptoRepository: CryptoRepository) : ViewModel() {

    private val _state = MutableStateFlow(CryptoDetailState())
    val state: StateFlow<CryptoDetailState> = _state

    fun getCoinDetail(coinId: String) {
        viewModelScope.launch {
            _state.value = CryptoDetailState(isLoading = true)
            try {
                val coin = cryptoRepository.getCoinDetail(coinId)
                _state.value = CryptoDetailState(coin = coin)
            } catch (e: Exception) {
                _state.value = CryptoDetailState(error = e.message ?: "An unexpected error occurred")
            }
        }
    }
}
