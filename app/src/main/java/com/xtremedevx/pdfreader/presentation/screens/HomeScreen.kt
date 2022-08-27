package com.xtremedevx.pdfreader.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.xtremedevx.pdfreader.navigation.BottomBarScreen

@Composable
fun HomeScreen() {
    Text(text = "Home Screen", textAlign = TextAlign.Center, modifier = Modifier.fillMaxSize())
}