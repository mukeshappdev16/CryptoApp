package com.ms.cryptoapp.kmp

actual fun getPlatformVersion(): String {
    return "Java ${System.getProperty("java.version")}"
}
