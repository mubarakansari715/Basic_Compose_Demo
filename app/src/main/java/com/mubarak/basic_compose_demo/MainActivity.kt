package com.mubarak.basic_compose_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mubarak.basic_compose_demo.navigation.MobileNavigation
import com.mubarak.basic_compose_demo.ui.theme.Basic_Compose_DemoTheme
import com.mubarak.basic_compose_demo.utils.TopBarManage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Basic_Compose_DemoTheme {
                // A surface container using the 'background' color from the theme

                Scaffold(
                    topBar = { TopBarManage() },
                    content = { MobileNavigation() })
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