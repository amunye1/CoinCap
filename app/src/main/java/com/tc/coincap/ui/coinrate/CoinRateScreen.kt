package com.tc.coincap.ui.coinrate

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tc.coincap.data.model.DataModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoinRateScreen(navController: NavController) {
    val viewModel: CoinRateViewModel = hiltViewModel()
    val coinList by viewModel.coin.collectAsState(initial = null)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Check if coinList is not null and iterate through the list
        coinList?.data?.forEach { coinItem ->
            item {
                Box(modifier = Modifier.fillMaxWidth()) { // Box to center the Card
                    Card(
                        modifier = Modifier
                            .padding(top = 16.dp, bottom = 16.dp)
                            .align(Alignment.Center) ,// Align the Card in the center of the Box
                        onClick = {
                            // Navigate to DetailScreen with the selected coin's ID
                            coinItem?.id?.let { id ->
                                navController.navigate("coinDetailScreen/$id")
                            }
                        }
                    ) {
                        Text(
                            text = "Symbol: ${coinItem?.symbol}\n" +
                                    "Currency Symbol: ${coinItem?.currencySymbol}\n" +
                                    "Rate: ${coinItem?.rateUsd}",
                            textAlign = TextAlign.Center, // Center-align the text
                            color = Color.Black,
                            style = TextStyle(fontSize = 18.sp),
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth() // Ensure the Text fills the width of the Card
                        )


                    }
                }
            }
        }
    }
}

