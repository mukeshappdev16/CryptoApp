package com.ms.cryptoapp

import android.app.Application
import com.ms.cryptoapp.di.initKoin
import org.koin.android.ext.koin.androidContext

class CryptoApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@CryptoApp)
        }
    }
}
