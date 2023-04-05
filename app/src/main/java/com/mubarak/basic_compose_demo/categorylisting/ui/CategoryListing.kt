package com.mubarak.basic_compose_demo.categorylisting.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewModelScope
import com.mubarak.basic_compose_demo.categorylisting.item.CategoryItem
import com.mubarak.basic_compose_demo.categorylisting.model.CategoryListResponseModel
import com.mubarak.basic_compose_demo.categorylisting.viewmodel.CategoryViewModel
import com.mubarak.basic_compose_demo.network.ResponseHandler
import com.mubarak.basic_compose_demo.utils.ShowLoader
import com.mubarak.basic_compose_demo.utils.ToolBarData
import kotlinx.coroutines.launch

@Composable
fun CategoryListing(
    toolBarData: (ToolBarData) -> Unit,
    viewModel: CategoryViewModel
) {
    val context = LocalContext.current
    var isLoading by remember { mutableStateOf(false) }
    val photoList = viewModel.photoList

    LaunchedEffect(Unit) {
        toolBarData(
            ToolBarData(
                title = "Product List",
                isVisible = true,
                isDrawerIcon = false,
                isBackIcon = true
            )
        )

        viewModel.viewModelScope.launch {

            viewModel.photosResponse.collect {

                when (it) {

                    is ResponseHandler.Loading -> {
                        isLoading = true
                    }
                    is ResponseHandler.Empty -> {
                        isLoading = false
                    }
                    is ResponseHandler.OnFailed -> {
                        isLoading = false
                    }

                    is ResponseHandler.OnSuccessResponse<List<CategoryListResponseModel>> -> {
                        isLoading = false
                        viewModel.setPhotoList(it.response)
                    }
                }
            }

        }

    }


    SetPhotoData(photo = photoList)
    ShowLoader(isLoading = isLoading)
}

@Composable
fun SetPhotoData(photo: List<CategoryListResponseModel>) {

    LazyColumn {
        itemsIndexed(items = photo, itemContent = { _, data ->
            CategoryItem(data)
        })
    }
}