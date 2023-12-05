package com.tc.coincap.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.tc.coincap.ui.coindetail.CoinDetailScreen
import com.tc.coincap.ui.coinrate.CoinRateScreen

@Composable
fun NavigationHost(navController:NavHostController){
    NavHost(navController = navController, startDestination = Screen.CoinScreen.route) {
        composable(Screen.CoinScreen.route) {
            CoinRateScreen(navController = navController)
        }
        composable(
            route = Screen.DetailScreen.route,
            arguments = listOf(navArgument("coinId") { type = NavType.StringType }) // Define the argument
        ) { backStackEntry ->
            // Extract the coinId from the backStackEntry
            val coinId = backStackEntry.arguments?.getString("coinId") ?: return@composable
            CoinDetailScreen(navController = navController, coinId = coinId)
        }
    }
}