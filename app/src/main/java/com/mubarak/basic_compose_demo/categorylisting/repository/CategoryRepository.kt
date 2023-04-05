package com.mubarak.basic_compose_demo.categorylisting.repository

import com.mubarak.basic_compose_demo.categorylisting.model.CategoryListResponseModel
import com.mubarak.basic_compose_demo.network.ApiClient
import com.mubarak.basic_compose_demo.network.ResponseHandler

class CategoryRepository {

    suspend fun getPhotos(): ResponseHandler<List<CategoryListResponseModel>> {
        return try {
            val response = ApiClient.getClient().getPhotos()
            ResponseHandler.OnSuccessResponse(response)
        } catch (e: Exception) {
            ResponseHandler.OnFailed(e.hashCode(), e.message.toString(), "0")
        }
    }

}