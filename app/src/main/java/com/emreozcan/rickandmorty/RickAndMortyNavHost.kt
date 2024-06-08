package com.emreozcan.rickandmorty

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.emreozcan.rickandmorty.detail.DETAIL_ROUTE_ARGUMENT
import com.emreozcan.rickandmorty.detail.DetailScreen
import com.emreozcan.rickandmorty.detail.detailNavGraph
import com.emreozcan.rickandmorty.home.HOME_ROUTE
import com.emreozcan.rickandmorty.home.homeNavGraph

/**
 * Created by @Emre Özcan on 4.06.2024
 */
@Composable
fun RickAndMortyNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = HOME_ROUTE) {
        homeNavGraph { characterId ->
            navController.navigate(
                DetailScreen.Detail.route.replace(
                    DETAIL_ROUTE_ARGUMENT,
                    characterId,
                ),
            )
        }
        detailNavGraph(navController)
    }
}
