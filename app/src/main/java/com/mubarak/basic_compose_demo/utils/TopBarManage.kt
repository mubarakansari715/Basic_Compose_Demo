package com.mubarak.basic_compose_demo.utils

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable

@Composable
fun TopBarManage(
    title:String,
) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Menu, contentDescription = "menu")
            }
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Notifications, contentDescription = "notification")
            }

            IconButton(onClick = { }) {
                Icon(Icons.Filled.Search, contentDescription = "search")
            }
        }
    )
}