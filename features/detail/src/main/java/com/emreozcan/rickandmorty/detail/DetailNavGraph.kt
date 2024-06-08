package com.emreozcan.rickandmorty.detail

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.emreozcan.rickandmorty.detail.detail.DetailScreen

/**
 * Created by @Emre Özcan on 8.06.2024
 */

const val DETAIL_ROUTE = "detail_route"
const val DETAIL_ROUTE_ARGUMENT = "{characterId}"

sealed class DetailScreen(val route: String) {
    data object Detail : DetailScreen("$DETAIL_ROUTE/detail/$DETAIL_ROUTE_ARGUMENT")
}

fun NavGraphBuilder.detailNavGraph(navController: NavController) {
    navigation(startDestination = DetailScreen.Detail.route, route = DETAIL_ROUTE) {
        composable(DetailScreen.Detail.route) {
            DetailScreen(viewModel = hiltViewModel(), navigateUp = { navController.popBackStack() })
        }
    }
}
