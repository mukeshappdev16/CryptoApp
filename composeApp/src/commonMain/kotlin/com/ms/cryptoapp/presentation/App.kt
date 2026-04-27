package com.ms.cryptoapp.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.ms.cryptoapp.common.DetailRoute
import com.ms.cryptoapp.common.HomeRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
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
                            text = if (navBackStackEntry?.destination?.route?.contains("DetailRoute") == true) 
                                "Coin Detail" else "Crypto Currencies"
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
            }
        }
    }
}
