package com.mubarak.basic_compose_demo.post.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mubarak.basic_compose_demo.network.ResponseHandler
import com.mubarak.basic_compose_demo.post.model.Post
import com.mubarak.basic_compose_demo.post.repository.PostRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {

    private val postRepository = PostRepository()

    /* private val _posts = MutableLiveData<ResponseHandler<List<Post>>>()
     val posts: LiveData<ResponseHandler<List<Post>>>
         get() = _posts*/

    private val _posts = MutableStateFlow<ResponseHandler<List<Post>>>(ResponseHandler.Empty)
    val posts = _posts as StateFlow<ResponseHandler<List<Post>>>

    private val _postsList :MutableList<Post> = mutableStateListOf()
    val postsList :List<Post> = _postsList

    fun setPostList(list:List<Post>) {
        _postsList.addAll(list)
    }

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