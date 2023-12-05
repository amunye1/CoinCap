package com.tc.coincap.ui.coinrate

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tc.coincap.data.model.DataModel


@Composable
fun CoinRateScreen(){
    val viewModel = hiltViewModel <CoinRateViewModel>()

    val coin by viewModel.coin.collectAsState(null)

    DisposableEffect(Unit) {
        viewModel.getCoin()
        onDispose { /* Cleanup if needed */ }
    }

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center) {

        Log.d("The Rate" , "${coin?.rateUsd} ")
        if(!coin?.id.isNullOrEmpty()){

            item {
                Text(
                    text = coin?.rateUsd ?: "", // Display the value of the random joke
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    style = TextStyle(fontSize = 18.sp),
                    modifier = Modifier.padding(16.dp)

                )
            }

        }
    }
}