package com.zibran.brutoapp.presentation.screens.splash

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.zibran.brutoapp.R
import com.zibran.brutoapp.navigation.Screen
import com.zibran.brutoapp.ui.theme.Purple40
import com.zibran.brutoapp.ui.theme.Purple80

@Composable
fun SplashScreen(
    navHostController: NavHostController,
    splashViewModel: SplashViewModel = hiltViewModel()
) {

    val onBoardingCompleted by splashViewModel.onBoardingCompleted.collectAsState()
    val degree = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        degree.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200
            )
        )
        navHostController.popBackStack()
        if (onBoardingCompleted) {
            navHostController.navigate(Screen.Home.route)
        } else {
            navHostController.navigate(Screen.Welcome.route)
        }
    }
    Splash(degree.value)

}

@Composable
fun Splash(degree: Float) {
    var modifier: Modifier = if (isSystemInDarkTheme()) {
        Modifier
            .background(Color.Black)
            .fillMaxSize()
    } else {
        Modifier
            .background(Brush.verticalGradient(listOf(Purple80, Purple40)))
            .fillMaxSize()
    }
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center

    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = stringResource(R.string.app_logo),
            modifier = Modifier.rotate(degrees = degree)
        )

    }

}

@Composable
@Preview
fun SplashPreview() {

    Splash(0f)
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun SplashPreviewDark() {

    Splash(0f)
}