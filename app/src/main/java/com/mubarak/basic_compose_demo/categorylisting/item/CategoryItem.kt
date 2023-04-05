package com.mubarak.basic_compose_demo.categorylisting.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.glide.rememberGlidePainter
import com.mubarak.basic_compose_demo.R
import com.mubarak.basic_compose_demo.categorylisting.model.CategoryListResponseModel

@Composable
fun CategoryItem(data: CategoryListResponseModel) {

    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = 5.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {

        Row {
            LoadImage(data)
            Column(modifier = Modifier.padding(5.dp)) {
                Text(text = data.title, style = typography.h6)
            }
        }


    }
}

@Preview
@Composable
fun CategoryPreview() {
    CategoryItem(CategoryListResponseModel(0, 0, "", "", ""))
}

@Composable
fun LoadImage(photo: CategoryListResponseModel) {
    /*Image(
        id = photo.thumbnailUrl,
        contentDescription = "img",
        contentScale = ContentScale.Crop
    )*/

    Image(
        painter = rememberGlidePainter(
            request = photo.thumbnailUrl,
            requestBuilder = {
                placeholder(R.drawable.ic_launcher_foreground)
                error(R.drawable.ic_launcher_background)
            }),
        contentScale = ContentScale.Crop,
        contentDescription = "img",
        modifier = Modifier.size(100.dp)
    )
}