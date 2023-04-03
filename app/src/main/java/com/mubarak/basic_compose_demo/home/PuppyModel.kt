package com.mubarak.basic_compose_demo.home

data class PuppyModel(
    val id: Int,
    val title: String,
    val sex: String,
    val age: Int,
    val description: String,
    val puppyImageId: Int = 0
)