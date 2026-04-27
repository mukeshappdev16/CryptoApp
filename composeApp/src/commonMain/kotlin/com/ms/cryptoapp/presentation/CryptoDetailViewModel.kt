package com.ms.cryptoapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ms.cryptoapp.domain.modal.CoinDetail
import com.ms.cryptoapp.domain.repository.CryptoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CryptoDetailViewModel(private val cryptoRepository: CryptoRepository) : ViewModel() {

    private val _coinDetail = MutableStateFlow<CoinDetail?>(null)
    val coinDetail: StateFlow<CoinDetail?> = _coinDetail

    fun getCoinDetail(coinId: String) {
        viewModelScope.launch {
            try {
                _coinDetail.value = cryptoRepository.getCoinDetail(coinId)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
