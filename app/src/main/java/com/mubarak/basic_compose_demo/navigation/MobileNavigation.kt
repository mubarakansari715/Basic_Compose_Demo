package com.mubarak.basic_compose_demo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mubarak.basic_compose_demo.home.HomePage

@Composable
fun MobileNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomePage()
        }
    }
}