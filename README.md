# CryptoApp - Kotlin Multiplatform

A modern, cross-platform cryptocurrency tracking application built with **Compose Multiplatform**. This project demonstrates the power of shared code by targeting **Android**, **iOS**, and **Desktop (JVM)** with a single codebase for both logic and UI.

## 🚀 Features

- **Coin List**: Browse a comprehensive list of cryptocurrencies with their rank, symbol, and active/inactive status.
- **Coin Details**: View in-depth information about a specific coin, including its description and team members.
- **Light/Dark Mode**: Full support for system-wide light and dark themes using Material Design 3.
- **Adaptive UI**: Optimized layouts for mobile and desktop environments.
- **Type-Safe Navigation**: Secure and robust navigation between screens.
- **Platform-Specific Enhancements**: Includes native scrollbar support for Desktop.

## 🛠️ Tech Stack

- **UI Framework**: [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/)
- **Dependency Injection**: [Koin](https://insert-koin.io/)
- **Networking**: [Ktor](https://ktor.io/)
- **Serialization**: [Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization)
- **Architecture**: MVVM with Clean Architecture principles.
- **Lifecycle & State**: [Jetpack ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) (Multiplatform) and `StateFlow`.
- **API**: [CoinPaprika API](https://api.coinpaprika.com/)

## 🏗️ Project Structure

- `composeApp/src/commonMain`: Shared logic, UI components, ViewModels, and data repositories.
- `composeApp/src/androidMain`: Android-specific entry point and configuration.
- `composeApp/src/iosMain`: iOS-specific UIViewController and Koin initialization.
- `composeApp/src/jvmMain`: Desktop-specific window configuration and scrollbar implementation.
- `iosApp`: Native iOS project entry point using SwiftUI.

## 🚦 Getting Started

### Prerequisites

- Android Studio or IntelliJ IDEA
- Xcode (for running the iOS application)
- JDK 17 or higher

### Build and Run

#### Android
```shell
./gradlew :composeApp:assembleDebug
```

#### Desktop (JVM)
```shell
./gradlew :composeApp:run
```

#### iOS
Open the `iosApp` folder in **Xcode** and run the project, or use the run configuration in Android Studio.

## 📝 License

This project is open-source and available under the MIT License.
