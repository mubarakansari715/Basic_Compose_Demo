package com.mubarak.basic_compose_demo.post.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import com.mubarak.basic_compose_demo.network.ResponseHandler
import com.mubarak.basic_compose_demo.post.item.PostItemDesign
import com.mubarak.basic_compose_demo.post.model.Post
import com.mubarak.basic_compose_demo.post.viewmodel.PostViewModel

@Composable
fun PostDesignScreen() {

    val viewModel = remember { PostViewModel() }
    val postObserverState by viewModel.posts.observeAsState()

    when (postObserverState) {

        is ResponseHandler.Loading -> {

        }
        is ResponseHandler.Empty -> {

        }
        is ResponseHandler.OnFailed -> {

        }
        is ResponseHandler.OnSuccessResponse<List<Post>> -> {

            (postObserverState as ResponseHandler.OnSuccessResponse<List<Post>>).response.let {

                Log.e("@@@mubarak", "PostDesignScreen: $it")

                PostItemDesign(it)

            }
        }
    }

}