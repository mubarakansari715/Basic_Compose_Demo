package com.mubarak.basic_compose_demo.post.item

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mubarak.basic_compose_demo.post.model.Post

@Composable
fun PostItemDesign(post: List<Post>) {
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        /* items(post) { post ->
             Log.e("Mubarak", "PostList: $post")
             Text(text = post.id.toString())
         }*/
        itemsIndexed(post) { position, data ->

            Log.e("Mubarak", "PostList: $post")
            Text(text = data.id.toString())
        }
    }
}