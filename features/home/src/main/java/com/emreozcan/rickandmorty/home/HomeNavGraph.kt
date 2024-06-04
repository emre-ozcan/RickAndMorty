package com.emreozcan.rickandmorty.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

/**
 * Created by @Emre Özcan on 4.06.2024
 */

const val HOME_ROUTE = "home_route"

sealed class HomeScreen(val route: String) {
    data object Home : HomeScreen("$HOME_ROUTE/home")
}

fun NavGraphBuilder.homeNavGraph(navController: NavController) {
    navigation(startDestination = HomeScreen.Home.route, route = HOME_ROUTE) {
        composable(HomeScreen.Home.route) {
            HomeScreen()
        }
    }
}