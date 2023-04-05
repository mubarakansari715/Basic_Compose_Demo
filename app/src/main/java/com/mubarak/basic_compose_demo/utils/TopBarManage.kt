package com.mubarak.basic_compose_demo.utils

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable

@Composable
fun TopBarManage(
    toolBarData: ToolBarData,
    onBackIconClick: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(text = toolBarData.title)
        },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Filled.Menu, contentDescription = "menu")
            }
        },
        actions = {

            if (toolBarData.isBackIcon) {
                IconButton(onClick = { onBackIconClick.invoke() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "notification")
                }
            }

            IconButton(onClick = { }) {
                Icon(Icons.Filled.Search, contentDescription = "search")
            }
        }
    )
}