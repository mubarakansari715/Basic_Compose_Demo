package com.mubarak.basic_compose_demo.categorylisting.model

data class CategoryListResponseModel(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)