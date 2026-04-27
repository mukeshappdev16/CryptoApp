package com.ms.cryptoapp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.ms.cryptoapp.di.initKoin
import com.ms.cryptoapp.presentation.App

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "CryptoApp",
        ) {
            App()
        }
    }
}
