package com.example.pasteleriamilsabores.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pasteleriamilsabores.remote.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    val posts = MutableStateFlow(emptyList<com.example.pasteleriamilsabores.model.Post>())

    fun cargarPost(){
        viewModelScope.launch {
            val respuesta = RetrofitInstance.api.getPosts()
            posts.value = respuesta
        }

    }
}