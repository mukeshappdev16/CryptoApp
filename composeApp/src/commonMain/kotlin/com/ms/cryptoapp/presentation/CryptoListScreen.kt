package com.ms.cryptoapp.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ms.cryptoapp.domain.modal.Coin
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CryptoListScreen(
    modifier: Modifier = Modifier,
    viewModel: CryptoListViewModel = koinViewModel(),
    onCryptoClickListener: (String) -> Unit
) {
    val coins by viewModel.coins.collectAsState()

    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(coins) { coin ->
                CoinListItem(
                    coin = coin,
                    onItemClick = { onCryptoClickListener(coin.id) }
                )
                HorizontalDivider()
            }
        }
    }
}

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick: (Coin) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(coin) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.bodyLarge,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = if (coin.isActive) "active" else "inactive",
            color = if (coin.isActive) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
