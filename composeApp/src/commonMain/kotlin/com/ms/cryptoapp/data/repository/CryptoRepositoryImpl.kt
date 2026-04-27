package com.ms.cryptoapp.data.repository

import com.ms.cryptoapp.domain.modal.Coin
import com.ms.cryptoapp.domain.modal.CoinDetail
import com.ms.cryptoapp.domain.repository.CryptoRepository

class CryptoRepositoryImpl(): CryptoRepository {
    override suspend fun getCryptoCoins(): List<Coin> {
        return emptyList()
    }

    override suspend fun getCoinDetail(coinId: String): CoinDetail {

    }
}