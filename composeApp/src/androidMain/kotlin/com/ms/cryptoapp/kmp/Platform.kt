package com.ms.cryptoapp.kmp

import android.os.Build

actual fun getPlatformVersion(): String {
    return "Android ${Build.VERSION.RELEASE}"
}
