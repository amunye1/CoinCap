package com.tc.coincap.ui.coindetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun CoinDetailScreen(navController: NavController, coinId: String) {
    // Use coinId to fetch or display the data
    // For instance, you could have a ViewModel function to fetch data based on this ID
    val viewModel: CoinDetailViewModel = hiltViewModel()
    LaunchedEffect(coinId) {
        viewModel.getCoinDetails(coinId)
    }

    val coinDetails by viewModel.coinDetails.collectAsState()

    // Display the details
    // For example:
    Column {
        Text(text = "Details for Coin ID: ${coinDetails?.id}")
        Text(text = "Symbol: ${coinDetails?.symbol}")
        Text(text = "Currency Symbol: ${coinDetails?.currencySymbol}" )
        Text(text = "RateUSD: ${coinDetails?.rateUsd}")
        Text(text = "Type: ${coinDetails?.type}")
        // ... other details
    }

}

