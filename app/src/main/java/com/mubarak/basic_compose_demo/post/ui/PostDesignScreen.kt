package com.mubarak.basic_compose_demo.post.ui

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.mubarak.basic_compose_demo.home.ItemsClickedInterface
import com.mubarak.basic_compose_demo.network.ResponseHandler
import com.mubarak.basic_compose_demo.post.item.PostItemDesign
import com.mubarak.basic_compose_demo.post.model.Post
import com.mubarak.basic_compose_demo.post.viewmodel.PostViewModel

@Composable
fun PostDesignScreen(
    appContext:Context
) {

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
                                    Toast.makeText(appContext, data.body, Toast.LENGTH_SHORT).show()
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