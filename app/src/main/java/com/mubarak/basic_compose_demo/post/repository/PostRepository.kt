package com.mubarak.basic_compose_demo.post.repository

import com.mubarak.basic_compose_demo.network.ApiClient
import com.mubarak.basic_compose_demo.network.ResponseHandler
import com.mubarak.basic_compose_demo.network.ResponseHandlerList
import com.mubarak.basic_compose_demo.post.model.Post


class PostRepository {

    suspend fun getPosts(): ResponseHandler<List<Post>> {
        return try {
            val response = ApiClient.getClient().getPosts()
            ResponseHandler.OnSuccessResponse(response)
        } catch (e: Exception) {
            ResponseHandler.OnFailed(e.hashCode(), e.message.toString(), "0")
        }
    }

    suspend fun test(): ResponseHandlerList<List<Post>> {
        return try {
            val response = ApiClient.getClient().getPosts()
            ResponseHandlerList.OnSuccessResponse(response)
        } catch (e: Exception) {
            ResponseHandlerList.OnFailed(e.hashCode(), e.message.toString(), "0")
        }
    }
}