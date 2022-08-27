package com.xtremedevx.pdfreader.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.xtremedevx.pdfreader.presentation.screens.FavoriteScreen
import com.xtremedevx.pdfreader.presentation.screens.HomeScreen

@Composable
fun BottomNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.HomeScreen.route,
    ) {
        composable(route = BottomBarScreen.HomeScreen.route) {
            HomeScreen()
        }
        composable(route = BottomBarScreen.FavoriteScreen.route) {
            FavoriteScreen()
        }

    }
}