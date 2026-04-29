package com.ms.cryptoapp.kmp

import platform.UIKit.UIDevice

actual fun getPlatformVersion(): String {
    return UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}
