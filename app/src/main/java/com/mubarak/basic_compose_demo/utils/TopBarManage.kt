package com.mubarak.basic_compose_demo.utils

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable

@Composable
fun TopBarManage(
    toolBarData: ToolBarData,
    onDrawerIconClick: () -> Unit,
    onBackIconClick: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(text = toolBarData.title)
        },
        navigationIcon = {
            /*IconButton(onClick = {}) {
                Icon(Icons.Filled.Menu, contentDescription = "menu")
            }*/

            if (toolBarData.isDrawerIcon) {
                IconButton(onClick = onDrawerIconClick) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Toggle drawer"
                    )
                }
            }

            if (toolBarData.isBackIcon) {
                IconButton(onClick = onBackIconClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back arrow"
                    )
                }
            }
        },
        actions = {

            if (toolBarData.isBackIcon) {
                IconButton(onClick = { onBackIconClick.invoke() }) {
                    Icon(Icons.Filled.Notifications, contentDescription = "notification")
                }
            }

            IconButton(onClick = { }) {
                Icon(Icons.Filled.Search, contentDescription = "search")
            }
        }
    )
}