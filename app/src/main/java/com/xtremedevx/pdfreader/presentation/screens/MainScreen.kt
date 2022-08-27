package com.xtremedevx.pdfreader.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.xtremedevx.pdfreader.navigation.BottomBar
import com.xtremedevx.pdfreader.navigation.BottomNavGraph

@Composable
fun MainScreen(
    navController: NavHostController
) {
    Scaffold(modifier = Modifier.fillMaxSize(),
    bottomBar = { BottomBar(navController = navController)}
        ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
                BottomNavGraph(navController = navController)
        }
    }
}