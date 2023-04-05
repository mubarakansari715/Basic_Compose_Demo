package com.mubarak.basic_compose_demo.network

sealed class ResponseHandler<out T> {
    object Empty : ResponseHandler<Nothing>()
    object Loading : ResponseHandler<Nothing>()
    class OnFailed(val code: Int, val message: String, val messageCode: String) :
        ResponseHandler<Nothing>()

    class OnSuccessResponse<T>(val response: T) : ResponseHandler<T>()
}

sealed class ResponseHandlerList<out T> {
    object Empty : ResponseHandlerList<Nothing>()
    object Loading : ResponseHandlerList<Nothing>()
    class OnFailed(val code: Int, val message: String, val messageCode: String) :
        ResponseHandlerList<Nothing>()

    class OnSuccessResponse<T>(val response: List<T>) : ResponseHandlerList<List<T>>()
}
