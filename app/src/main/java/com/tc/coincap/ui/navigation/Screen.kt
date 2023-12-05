package com.tc.coincap.ui.navigation

enum class Screen(val route :String) {


    CoinScreen (route = "coinRateScreen"),
    DetailScreen(route = "coinDetailScreen/{coinId}")
}