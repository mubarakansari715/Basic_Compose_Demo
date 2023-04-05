package com.mubarak.basic_compose_demo.post.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mubarak.basic_compose_demo.network.ResponseHandler
import com.mubarak.basic_compose_demo.post.model.Post
import com.mubarak.basic_compose_demo.post.repository.PostRepository
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {

    private val postRepository = PostRepository()

    private val _posts = MutableLiveData<ResponseHandler<List<Post>>>()
    val posts: LiveData<ResponseHandler<List<Post>>>
        get() = _posts

    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            _posts.value = ResponseHandler.Loading
            _posts.value = postRepository.getPosts()
        }
    }
}