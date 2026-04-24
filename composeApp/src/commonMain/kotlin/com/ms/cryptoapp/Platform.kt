package com.ms.cryptoapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform