package com.baek.priceyay.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.baek.priceyay.ui.bookmark.BookmarkScreen
import com.baek.priceyay.ui.home.HomeScreen
import com.baek.priceyay.ui.search.SearchScreen

@Composable
fun PriceYayGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = PriceYayDestination.HomeDestination.route
    ) {
        composable(PriceYayDestination.HomeDestination.route) {
            HomeScreen(

            )
        }
        composable(PriceYayDestination.SearchDestination.route) {
            SearchScreen()
        }
        composable(PriceYayDestination.BookmarkDestination.route) {
            BookmarkScreen()
        }
    }
}