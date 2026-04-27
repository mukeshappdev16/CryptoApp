package com.ms.cryptoapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ms.cryptoapp.domain.modal.Coin
import com.ms.cryptoapp.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CryptoListViewModel(private val cryptoRepository: CryptoRepository) : ViewModel() {

    private val _coins = MutableStateFlow<List<Coin>>(emptyList())
    val coins: StateFlow<List<Coin>> = _coins

    init {
        getCoins()
    }

    private fun getCoins() {
        viewModelScope.launch {
            try {
                _coins.value = cryptoRepository.getCryptoCoins()
            } catch (e: Exception) {
                // handle error
            }
        }
    }
}
