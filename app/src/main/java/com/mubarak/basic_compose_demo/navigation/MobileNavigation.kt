package com.mubarak.basic_compose_demo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mubarak.basic_compose_demo.home.HomePage
import com.mubarak.basic_compose_demo.login.LoginPageDesign

@Composable
fun MobileNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {

        composable("home") {
            HomePage(navController)
        }

        composable("login"){
            LoginPageDesign(navController)
        }
    }
}