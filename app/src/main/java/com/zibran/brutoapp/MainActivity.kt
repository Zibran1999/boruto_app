package com.zibran.brutoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.zibran.brutoapp.navigation.SetupNavGraph
import com.zibran.brutoapp.ui.theme.BrutoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BrutoAppTheme {
                navHostController = rememberNavController()
                SetupNavGraph(navController = navHostController)

            }
        }
    }
}

