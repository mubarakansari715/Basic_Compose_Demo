package com.mubarak.basic_compose_demo.daggerhilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.mubarak.basic_compose_demo.ui.theme.Basic_Compose_DemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent { 
            Basic_Compose_DemoTheme() {
                Text(text = "Hello Happy")
            }
        }
    }
}