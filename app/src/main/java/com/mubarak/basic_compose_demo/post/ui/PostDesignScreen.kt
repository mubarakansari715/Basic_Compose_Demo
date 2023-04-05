package com.mubarak.basic_compose_demo.post.ui

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import com.mubarak.basic_compose_demo.home.ItemsClickedInterface
import com.mubarak.basic_compose_demo.network.ResponseHandler
import com.mubarak.basic_compose_demo.post.item.PostItemDesign
import com.mubarak.basic_compose_demo.post.model.Post
import com.mubarak.basic_compose_demo.post.viewmodel.PostViewModel
import com.mubarak.basic_compose_demo.utils.ShowLoader
import com.mubarak.basic_compose_demo.utils.ToolBarData
import kotlinx.coroutines.launch

@Composable
fun PostDesignScreen(
    toolBarData: (ToolBarData) -> Unit,
    viewModel: PostViewModel
) {
    val context = LocalContext.current
    var isLoading by remember { mutableStateOf(false) }
    val postList = remember { viewModel.postsList }

    LaunchedEffect(Unit) {
        toolBarData(
            ToolBarData(
                title = "From Api Post Listing",
                isVisible = true,
                isDrawerIcon = false,
                isBackIcon = true
            )
        )
        viewModel.viewModelScope.launch {
            viewModel.posts.collect { postObserverState ->

                when (postObserverState) {

                    is ResponseHandler.Loading -> {
                        isLoading = true
                    }
                    is ResponseHandler.Empty -> {
                        isLoading = false
                    }
                    is ResponseHandler.OnFailed -> {
                        isLoading = false
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
    ShowLoader(isLoading)

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