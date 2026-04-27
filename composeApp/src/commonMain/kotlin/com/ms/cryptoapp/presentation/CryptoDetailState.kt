package com.ms.cryptoapp.presentation

import com.ms.cryptoapp.domain.modal.CoinDetail

data class CryptoDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
