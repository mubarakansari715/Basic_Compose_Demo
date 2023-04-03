package com.mubarak.basic_compose_demo.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun PuppyListItem(
    puppy: PuppyModel,
    itemsClickedInterface: ItemsClickedInterface
) {
    val context = LocalContext.current
    /* Row(modifier = Modifier.fillMaxWidth()) {
         Column {
             Text(text = puppy.title, style = typography.h6)
             Text(text = "VIEW DETAIL ${puppy.description}", style = typography.caption)
         }
     }*/


    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),

        ) {
        Row(Modifier.clickable(
            onClick = {
                itemsClickedInterface.clickViewItems()
            }
        )) {
            PuppyImage(puppy)
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = puppy.title, style = typography.h6)
                Text(text = "VIEW DETAIL", style = typography.caption)

                Button(
                    onClick = { itemsClickedInterface.clickAddToCartButton() }
                ) {
                    Text(text = "Add to cart")
                }

            }
        }
    }
}

@Composable
private fun PuppyImage(puppy: PuppyModel) {
    Image(
        painter = painterResource(id = puppy.puppyImageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}