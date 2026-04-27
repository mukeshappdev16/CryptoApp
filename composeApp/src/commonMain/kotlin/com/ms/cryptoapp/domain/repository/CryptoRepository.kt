package com.ms.cryptoapp.domain.repository

import com.ms.cryptoapp.domain.modal.Coin
import com.ms.cryptoapp.domain.modal.CoinDetail

interface CryptoRepository {
    suspend fun getCryptoCoins(): List<Coin>

    suspend fun getCoinDetail(coinId: String): CoinDetail
}