package com.mubarak.basic_compose_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.mubarak.basic_compose_demo.navigation.MobileNavigation
import com.mubarak.basic_compose_demo.ui.theme.Basic_Compose_DemoTheme
import com.mubarak.basic_compose_demo.utils.ToolBarData
import com.mubarak.basic_compose_demo.utils.TopBarManage
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Basic_Compose_DemoTheme {
                // A surface container using the 'background' color from the theme
                val topBarState = remember { (mutableStateOf(ToolBarData())) }
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()

                val openDrawer: () -> Unit = { scope.launch { scaffoldState.drawerState.open() } }


                Box(modifier = Modifier) {
                    Scaffold(
                        topBar = {
                            if (topBarState.value.isVisible) {
                                TopBarManage(
                                    toolBarData = topBarState.value,
                                    onDrawerIconClick = {
                                        openDrawer()
                                    }, onBackIconClick = {
                                        navController.navigateUp()
                                    })
                            }
                        },
                        content = {
                            MobileNavigation(
                                navController = navController,
                                topBar = { topBarState.value = it })
                        })
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Basic_Compose_DemoTheme {
        Greeting("Android")
    }
}