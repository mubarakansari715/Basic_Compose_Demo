package com.mubarak.basic_compose_demo.network

import com.mubarak.basic_compose_demo.categorylisting.model.CategoryListResponseModel
import com.mubarak.basic_compose_demo.post.model.Post
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("photos")
    suspend fun getPhotos(): List<CategoryListResponseModel>

}
