package com.ms.cryptoapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ms.cryptoapp.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CryptoListViewModel(private val cryptoRepository: CryptoRepository) : ViewModel() {

    private val _state = MutableStateFlow(CryptoListState())
    val state: StateFlow<CryptoListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        viewModelScope.launch {
            _state.value = CryptoListState(isLoading = true)
            try {
                val coins = cryptoRepository.getCryptoCoins()
                _state.value = CryptoListState(coins = coins)
            } catch (e: Exception) {
                _state.value = CryptoListState(error = e.message ?: "An unexpected error occurred")
            }
        }
    }
}
