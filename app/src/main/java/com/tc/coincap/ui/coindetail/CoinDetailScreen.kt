package com.tc.coincap.ui.coindetail

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoinDetailScreen(navController: NavController, coinId: String) {
    // Use coinId to fetch or display the data
    // For instance, you could have a ViewModel function to fetch data based on this ID
    val viewModel: CoinDetailViewModel = hiltViewModel()
    LaunchedEffect(coinId) {
        viewModel.getCoinDetails(coinId)
    }

    val coinDetails by viewModel.coinDetails.collectAsState()
    Log.d("CoinDetailScreen", "Received coin ID: $coinId")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Coin Detail Screen") },

                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFFA877EE)),
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding->

        // Display the details

        Column(modifier = Modifier.padding(innerPadding)) {
            listOf(
                "Details for Coin ID: ${coinDetails?.id}",
                "Symbol: ${coinDetails?.symbol}",
                "Currency Symbol: ${coinDetails?.currencySymbol}",
                "RateUSD: ${coinDetails?.rateUsd}",
                "Type: ${coinDetails?.type}"
            ).forEach { text ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp) // Spacing between each box
                        .clip(RoundedCornerShape(10.dp)) // Rounded corners for the oval shape
                        .background(Color.LightGray), // Background color
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = text,
                        fontSize = 18.sp, // Bigger font size
                        modifier = Modifier.padding(16.dp), // Padding inside each box
                        textAlign = TextAlign.Center // Center-align the text
                    )
                }
            }
        }

    }



}

