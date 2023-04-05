package com.mubarak.basic_compose_demo.post.ui

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import com.mubarak.basic_compose_demo.home.ItemsClickedInterface
import com.mubarak.basic_compose_demo.network.ResponseHandler
import com.mubarak.basic_compose_demo.post.item.PostItemDesign
import com.mubarak.basic_compose_demo.post.model.Post
import com.mubarak.basic_compose_demo.post.viewmodel.PostViewModel
import kotlinx.coroutines.launch

@Composable
fun PostDesignScreen(
    appContext: Context
) {
    val context = LocalContext.current
    val viewModel = remember { PostViewModel() }
    //val postObserverState by viewModel.posts.observeAsState()
    var isLoading by remember { mutableStateOf(false) }
    val postList = viewModel.postsList

    /***
     * Show Loader on Screen
     */
    LoaderShow(isLoading)

    LaunchedEffect(Unit) {
        viewModel.viewModelScope.launch {
            viewModel.posts.collect { postObserverState ->

                when (postObserverState) {

                    is ResponseHandler.Loading -> {
                        isLoading = true
                    }
                    is ResponseHandler.Empty -> {

                    }
                    is ResponseHandler.OnFailed -> {

                    }
                    is ResponseHandler.OnSuccessResponse<List<Post>> -> {
                        isLoading = false
                        postObserverState.response.let {
                            viewModel.setPostList(it)
                            Log.e("@@@mubarak", "PostDesignScreen: $it")


                        }
                    }

                }

            }
        }
    }

    DataPost(context = context, post = postList)

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

@Composable
fun DataPost(context: Context, post: List<Post>) {
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {

        itemsIndexed(
            items = post,
            itemContent = { position, data ->
                PostItemDesign(position, data, object : ItemsClickedInterface {
                    override fun clickViewItems() {
                        Toast.makeText(context, data.body, Toast.LENGTH_SHORT)
                            .show()
                    }

                    override fun clickAddToCartButton() {
                        Toast.makeText(context, data.title, Toast.LENGTH_SHORT)
                            .show()
                    }
                })
            }
        )
    }
}