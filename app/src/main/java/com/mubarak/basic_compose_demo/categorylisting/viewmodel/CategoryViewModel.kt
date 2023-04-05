package com.mubarak.basic_compose_demo.categorylisting.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mubarak.basic_compose_demo.categorylisting.model.CategoryListResponseModel
import com.mubarak.basic_compose_demo.categorylisting.repository.CategoryRepository
import com.mubarak.basic_compose_demo.network.ResponseHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CategoryViewModel : ViewModel() {

    private val categoryRepository = CategoryRepository()

    private val _photos =
        MutableStateFlow<ResponseHandler<List<CategoryListResponseModel>>>(ResponseHandler.Empty)
    val photosResponse = _photos as StateFlow<ResponseHandler<List<CategoryListResponseModel>>>

    private val _photoList: MutableList<CategoryListResponseModel> = mutableStateListOf()
    val photoList: List<CategoryListResponseModel> = _photoList


    init {
        getPhotos()
    }

    private fun getPhotos() {
        viewModelScope.launch {
            _photos.value = ResponseHandler.Loading
            _photos.value = categoryRepository.getPhotos()
        }
    }

    fun setPhotoList(photoList: List<CategoryListResponseModel>) {
        _photoList.addAll(photoList)
    }
}