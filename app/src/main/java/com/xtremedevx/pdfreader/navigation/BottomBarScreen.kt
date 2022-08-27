package com.xtremedevx.pdfreader.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val OutlinedIcon: ImageVector,
    val FilledIcon: ImageVector,
) {

    object HomeScreen : BottomBarScreen(
        route = "home_screen",
        title = "Home",
        OutlinedIcon = Icons.Outlined.Home,
        FilledIcon = Icons.Filled.Home,
    )

    object FavoriteScreen : BottomBarScreen(
        route = "favorite_screen",
        title = "Favorite",
        OutlinedIcon = Icons.Default.FavoriteBorder,
        FilledIcon = Icons.Default.FavoriteBorder,
    )

}
