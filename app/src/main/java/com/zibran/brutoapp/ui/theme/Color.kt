package com.zibran.brutoapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val LightGrey = Color(0xFFD8D8D8)
val DarkGrey = Color(0xFF2A2A2A)
val StarColor = Color(0xFFFFC94D)

val ShimmerLightGray = Color(0xFFF1F1F1)
val ShimmerMediumGray = Color(0xFFE3E3E3)
val ShimmerDarkGray = Color(0xFF1D1D1D)

val ColorScheme.welcomeScreenBackgroundColor
    @Composable
    get() = if (isSystemInDarkTheme()) Color.Black else Color.White

val ColorScheme.titleColor
    @Composable
    get() = if (isSystemInDarkTheme()) LightGrey else DarkGrey
val ColorScheme.descriptionColor
    @Composable
    get() = if (isSystemInDarkTheme()) LightGrey.copy(alpha = 0.5f) else DarkGrey.copy(alpha = 0.5f)

val ColorScheme.activeIndicatorColor
    @Composable
    get() = if (isSystemInDarkTheme()) Purple40 else Purple80

val ColorScheme.inActiveIndicatorColor
    @Composable
    get() = if (isSystemInDarkTheme()) DarkGrey else LightGrey

val ColorScheme.buttonColor
    @Composable
    get() = if (isSystemInDarkTheme()) Purple40 else Purple80

val ColorScheme.topAppBarContentColor
    @Composable
    get() = if (isSystemInDarkTheme()) Color.LightGray else Color.White

val ColorScheme.topAppBarBackgroundColor
    @Composable
    get() = if (isSystemInDarkTheme()) Color.Black else Purple40
val ColorScheme.statusBarColor
    @Composable
    get() = if (isSystemInDarkTheme()) Color.Black else Purple40