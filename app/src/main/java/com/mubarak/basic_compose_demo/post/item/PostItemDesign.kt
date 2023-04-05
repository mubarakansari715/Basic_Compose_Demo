package com.mubarak.basic_compose_demo.post.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mubarak.basic_compose_demo.home.ItemsClickedInterface
import com.mubarak.basic_compose_demo.post.model.Post

@Composable
fun PostItemDesign(
    position: Int,
    model: Post,
    itemsClickedInterface: ItemsClickedInterface
) {

    Card(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .clickable { itemsClickedInterface.clickViewItems() },
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()

        ) {

            //title
            Text(
                text = model.title,
                style = typography.h6,
                modifier = Modifier.clickable {
                    itemsClickedInterface.clickAddToCartButton()
                }
            )

            //body
            Text(text = model.body, style = typography.caption)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOfItem() {
    //PostItemDesign()
}