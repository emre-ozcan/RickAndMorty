package com.emreozcan.rickandmorty.home

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.emreozcan.rickandmorty.home.home.HomeScreen

/**
 * Created by @Emre Özcan on 4.06.2024
 */

const val HOME_ROUTE = "home_route"

sealed class HomeScreen(val route: String) {
    data object Home : HomeScreen("$HOME_ROUTE/home")
}

fun NavGraphBuilder.homeNavGraph(navigateToDetail: (String) -> Unit) {
    navigation(startDestination = HomeScreen.Home.route, route = HOME_ROUTE) {
        composable(HomeScreen.Home.route) {
            HomeScreen(viewModel = hiltViewModel(), navigateToDetail = navigateToDetail)
        }
    }
}
