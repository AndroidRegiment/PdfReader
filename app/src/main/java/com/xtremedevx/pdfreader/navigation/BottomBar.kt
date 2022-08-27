package com.xtremedevx.pdfreader.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.HomeScreen,
        BottomBarScreen.FavoriteScreen,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation() {
        screens.forEach { screen ->
            AddBottomNavItem(
                currentDestination = currentDestination,
                navController = navController,
                screen = screen,
            )
        }
    }
}

@Composable
fun RowScope.AddBottomNavItem(
    screen: BottomBarScreen,
    navController: NavHostController,
    currentDestination: NavDestination?,
) {
    val selected = currentDestination?.hierarchy?.any {
        it.route == screen.route
    } == true

    BottomNavigationItem(
        selected = selected,
        icon = {
            Icon(
                imageVector = if (selected) screen.FilledIcon else screen.OutlinedIcon,
                contentDescription = null
            )
        },
        label = { Text(text = screen.title) },
        onClick = {
                  navController.navigate(screen.route){
                      popUpTo(id = navController.graph.findStartDestination().id)
                      launchSingleTop = true
                  }
        },
    )
}