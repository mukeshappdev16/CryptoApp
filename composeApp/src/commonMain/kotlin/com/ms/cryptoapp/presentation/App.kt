package com.ms.cryptoapp.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.ms.cryptoapp.common.DetailRoute
import com.ms.cryptoapp.common.HomeRoute
import com.ms.cryptoapp.common.InfoRoute

import com.ms.cryptoapp.presentation.theme.CryptoAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    CryptoAppTheme {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        
        val canNavigateBack by remember(navBackStackEntry) {
            derivedStateOf {
                navController.previousBackStackEntry != null
            }
        }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = when {
                                navBackStackEntry?.destination?.route?.contains("DetailRoute") == true -> "Coin Detail"
                                navBackStackEntry?.destination?.route?.contains("InfoRoute") == true -> "About"
                                else -> "Crypto Currencies"
                            }
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    navigationIcon = {
                        if (canNavigateBack) {
                            IconButton(onClick = { navController.navigateUp() }) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Back"
                                )
                            }
                        }
                    },
                    actions = {
                        val isInfoScreen = navBackStackEntry?.destination?.route?.contains("InfoRoute") == true
                        if (!isInfoScreen) {
                            IconButton(onClick = { navController.navigate(InfoRoute) }) {
                                Icon(
                                    imageVector = Icons.Default.Info,
                                    contentDescription = "App Info"
                                )
                            }
                        }
                    }
                )
            }
        ) { innerPadding ->
            NavHost(navController, startDestination = HomeRoute) {
                composable<HomeRoute> {
                    CryptoListScreen(modifier = Modifier.padding(innerPadding)) { coinId ->
                        navController.navigate(DetailRoute(coinId))
                    }
                }
                composable<DetailRoute> { backStackEntry ->
                    val detailRoute: DetailRoute = backStackEntry.toRoute()
                    CryptoDetailScreen(
                        coinId = detailRoute.coinId,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
                composable<InfoRoute> {
                    AppInfoScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
