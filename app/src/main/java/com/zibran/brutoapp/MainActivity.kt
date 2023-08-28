package com.zibran.brutoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.zibran.brutoapp.domain.use_cases.UseCases
import com.zibran.brutoapp.navigation.Screen
import com.zibran.brutoapp.navigation.SetupNavGraph
import com.zibran.brutoapp.ui.theme.BrutoAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navHostController: NavHostController

    @Inject
    lateinit var useCases: UseCases
    var completed = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            BrutoAppTheme {
                navHostController = rememberNavController()
                SetupNavGraph(
                    navController = navHostController,
                    startDestination = if (completed) Screen.Home.route else Screen.Welcome.route
                )

            }
        }
        lifecycleScope.launch(Dispatchers.IO) {

            useCases.readOnBoardingUseCase().collect() {
                completed = false

            }
        }
    }
}

