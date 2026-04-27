package com.ms.cryptoapp.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ms.cryptoapp.data.dto.Team
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CryptoDetailScreen(
    coinId: String,
    modifier: Modifier = Modifier,
    viewModel: CryptoDetailViewModel = koinViewModel()
) {
    val coinDetail by viewModel.coinDetail.collectAsState()

    LaunchedEffect(coinId) {
        viewModel.getCoinDetail(coinId)
    }

    Box(modifier = modifier.fillMaxSize()) {
        coinDetail?.let { detail ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${detail.rank}. ${detail.name} (${detail.symbol})",
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier.weight(8f)
                        )
                        Text(
                            text = if (detail.isActive) "active" else "inactive",
                            color = if (detail.isActive) Color.Green else Color.Red,
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.End,
                            modifier = Modifier.align(Alignment.CenterVertically).weight(2f)
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = detail.description,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    if (detail.team.isNotEmpty()) {
                        Text(
                            text = "Team members",
                            style = MaterialTheme.typography.headlineSmall
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                }
                items(detail.team) { teamMember ->
                    TeamListItem(
                        teamMember = teamMember,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )
                    HorizontalDivider()
                }
            }
        } ?: run {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Composable
fun TeamListItem(
    teamMember: Team,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = teamMember.name,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = teamMember.position,
            style = MaterialTheme.typography.bodySmall,
            fontStyle = FontStyle.Italic
        )
    }
}
