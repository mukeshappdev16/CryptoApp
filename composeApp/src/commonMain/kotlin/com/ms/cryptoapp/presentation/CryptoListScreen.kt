package com.ms.cryptoapp.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ms.cryptoapp.domain.modal.Coin

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CryptoListScreen(
    coinList: List<Coin> = emptyList(),
    modifier: Modifier,
    onCryptoClickListener: () -> Unit
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(coinList.count()) {
            Text(
                text = coinList[it].name,
                modifier = Modifier.fillMaxWidth().padding(16.dp).clickable {
                    onCryptoClickListener()
                }
            )
        }
    }
}