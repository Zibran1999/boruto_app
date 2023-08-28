package com.zibran.brutoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.zibran.brutoapp.presentation.screens.details.DetailScreen
import com.zibran.brutoapp.presentation.screens.home.HomeScreen
import com.zibran.brutoapp.presentation.screens.search.SearchScreen
import com.zibran.brutoapp.presentation.screens.welocome.WelcomeScreen
import com.zibran.brutoapp.utils.Constants.DETAILS_ARGUMENT_KEY

@Composable
fun SetupNavGraph(navController: NavHostController, startDestination: String) {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable(Screen.Welcome.route) {

            WelcomeScreen(navHostController = navController)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            Screen.Details.route,
            arguments = listOf(navArgument(name = DETAILS_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {

            DetailScreen(navController = navController)
        }
        composable(Screen.Search.route) {
            SearchScreen(navController = navController)
        }

    }

}