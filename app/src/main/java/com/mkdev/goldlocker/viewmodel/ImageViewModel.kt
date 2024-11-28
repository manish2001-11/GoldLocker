package com.mkdev.goldlocker.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mkdev.goldlocker.R
class ImageViewModel: ViewModel() {

    private val _images = MutableLiveData<List<Int>>()
    val images: LiveData<List<Int>> get() = _images

    init {
        loadImages()
    }

    private fun loadImages() {
        // Add image resource IDs to the list
        _images.value = listOf(
            R.drawable.d,
            R.drawable.e,
        )
    }
}