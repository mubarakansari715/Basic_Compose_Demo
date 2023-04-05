package com.mubarak.basic_compose_demo.post.ui

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mubarak.basic_compose_demo.MainActivity
import com.mubarak.basic_compose_demo.home.ItemsClickedInterface
import com.mubarak.basic_compose_demo.navigation.MobileNavigation
import com.mubarak.basic_compose_demo.network.ResponseHandler
import com.mubarak.basic_compose_demo.post.item.PostItemDesign
import com.mubarak.basic_compose_demo.post.model.Post
import com.mubarak.basic_compose_demo.post.viewmodel.PostViewModel
import com.mubarak.basic_compose_demo.utils.TopBarManage

@Composable
fun PostDesignScreen(
    appContext: Context
) {

    val viewModel = remember { PostViewModel() }
    val postObserverState by viewModel.posts.observeAsState()
    var isLoading by remember { mutableStateOf(false) }

    /***
     * Show Loader on Screen
     */
    LoaderShow(isLoading)

    when (postObserverState) {

        is ResponseHandler.Loading -> {
            LaunchedEffect(Unit) {
                isLoading = true
                // perform the loading operation here
                //isLoading = false
            }
        }
        is ResponseHandler.Empty -> {

        }
        is ResponseHandler.OnFailed -> {

        }
        is ResponseHandler.OnSuccessResponse<List<Post>> -> {
            isLoading = false
            (postObserverState as ResponseHandler.OnSuccessResponse<List<Post>>).response.let {

                Log.e("@@@mubarak", "PostDesignScreen: $it")

                LazyColumn(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    /*items(
                        items = it,
                        itemContent = {
                            PostItemDesign(it)
                        }
                    )*/

                    itemsIndexed(
                        items = it,
                        itemContent = { position, data ->
                            PostItemDesign(position, data, object : ItemsClickedInterface {
                                override fun clickViewItems() {
                                    Toast.makeText(appContext, data.body, Toast.LENGTH_SHORT)
                                        .show()
                                }

                                override fun clickAddToCartButton() {
                                    Toast.makeText(appContext, data.title, Toast.LENGTH_SHORT)
                                        .show()
                                }
                            })
                        }
                    )
                }
            }
        }

    }
}

@Composable
fun LoaderShow(isLoading: Boolean) {

    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        // your main UI code here
/*
        Scaffold(
            topBar = { TopBarManage("Post Listing") },
            content = {  })*/

    }
}