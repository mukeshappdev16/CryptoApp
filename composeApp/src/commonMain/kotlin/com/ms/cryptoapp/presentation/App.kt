package com.ms.cryptoapp.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ms.cryptoapp.common.DetailRoute
import com.ms.cryptoapp.common.HomeRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Crypto Currencies") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    )
                )
            }
        ) { innerPadding ->
            NavHost(navController, startDestination = HomeRoute) {
                composable<HomeRoute> {
                    CryptoListScreen(modifier = Modifier.padding(innerPadding)) {
                        navController.navigate(DetailRoute)
                    }
                }
                composable<DetailRoute> { backStackEntry ->
                    CryptoDetailScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}