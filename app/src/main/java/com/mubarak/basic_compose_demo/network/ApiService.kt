package com.mubarak.basic_compose_demo.network

import com.mubarak.basic_compose_demo.post.model.Post
import retrofit2.http.GET

interface ApiService {

    /*@GET("rest/V1/checkout/timeslots/611")
    suspend fun getUser(
        @Query("storeId") storeId: String = "1"
    ): Response<DeliveryDataModel>
*/

    @GET("posts")
    suspend fun getPosts(): List<Post>

}
