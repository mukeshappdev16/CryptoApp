package com.ms.cryptoapp.di

import com.ms.cryptoapp.data.repository.CryptoRepositoryImpl
import com.ms.cryptoapp.domain.repository.CryptoRepository
import com.ms.cryptoapp.presentation.CryptoDetailViewModel
import com.ms.cryptoapp.presentation.CryptoListViewModel
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val appModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                })
            }
        }
    }
    single<CryptoRepository> { CryptoRepositoryImpl(get()) }
    
    factory { CryptoListViewModel(get()) }
    factory { CryptoDetailViewModel(get()) }
}
