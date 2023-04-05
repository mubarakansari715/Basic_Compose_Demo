package com.mubarak.basic_compose_demo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mubarak.basic_compose_demo.categorylisting.ui.CategoryListing
import com.mubarak.basic_compose_demo.categorylisting.viewmodel.CategoryViewModel
import com.mubarak.basic_compose_demo.home.HomePage
import com.mubarak.basic_compose_demo.login.LoginPageDesign
import com.mubarak.basic_compose_demo.post.ui.PostDesignScreen
import com.mubarak.basic_compose_demo.post.viewmodel.PostViewModel
import com.mubarak.basic_compose_demo.utils.ToolBarData

@Composable
fun MobileNavigation(
    navController: NavHostController,
    topBar: (ToolBarData) -> Unit,
) {

    NavHost(navController = navController, startDestination = "login") {

        composable("home") {
            HomePage(navController, toolBarData = topBar)
        }

        composable("login") {
            LoginPageDesign(navController = navController, toolBarData = topBar)
        }

        composable("post") { backStackEntry ->

            val viewModel = remember { PostViewModel() }
            PostDesignScreen(toolBarData = topBar, viewModel)
        }

        composable("product") {
            val viewModels = remember { CategoryViewModel() }
            CategoryListing(toolBarData = topBar, viewModel = viewModels)
        }
    }
}