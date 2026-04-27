package com.ms.cryptoapp.data.repository

import com.ms.cryptoapp.data.dto.CoinDetailDto
import com.ms.cryptoapp.data.dto.CoinDto
import com.ms.cryptoapp.data.dto.toCoin
import com.ms.cryptoapp.data.dto.toCoinDetail
import com.ms.cryptoapp.domain.modal.Coin
import com.ms.cryptoapp.domain.modal.CoinDetail
import com.ms.cryptoapp.domain.repository.CryptoRepository
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class CryptoRepositoryImpl(private val httpClient: HttpClient): CryptoRepository {
    override suspend fun getCryptoCoins(): List<Coin> {
        return httpClient.get("https://api.coinpaprika.com/v1/coins")
            .body<List<CoinDto>>()
            .map { it.toCoin() }
    }

    override suspend fun getCoinDetail(coinId: String): CoinDetail {
        return httpClient.get("https://api.coinpaprika.com/v1/coins/$coinId")
            .body<CoinDetailDto>()
            .toCoinDetail()
    }
}
