package com.mubarak.basic_compose_demo.home

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mubarak.basic_compose_demo.utils.ToolBarData

@Composable
fun HomePage(
    navController: NavController,
    toolBarData: (ToolBarData) -> Unit
) {
    val context = LocalContext.current
    val puppies = remember { DataProvider.puppyList }

    LaunchedEffect(Unit) {
        toolBarData(
            ToolBarData(
                title = "Dummy data",
                isVisible = true,
                isDrawerIcon = false,
                isBackIcon = true
            )
        )
    }


    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = puppies,
            itemContent = {
                /*for (i in 0..50) {
                    PuppyListItem(puppy = it, object : ItemsClickedInterface {
                        override fun clickItems() {
                            Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
                        }
                    })
                    i + 1
                }*/
                PuppyListItem(puppy = it, object : ItemsClickedInterface {
                    override fun clickViewItems() {
                        Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
                    }

                    override fun clickAddToCartButton() {
                        Toast.makeText(context, it.id.toString(), Toast.LENGTH_SHORT).show()

                    }
                })

            },

            )

    }
}