package com.example.pasteleriamilsabores.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pasteleriamilsabores.model.Post
import com.example.pasteleriamilsabores.remote.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    val posts = MutableStateFlow(emptyList<Post>())

    fun cargarPost(){
        viewModelScope.launch {
            try {
                val respuesta = RetrofitInstance.api.getPosts()
                posts.value = respuesta
            } catch (e: Exception) {
                Log.e("PostViewModel", "Error al cargar los posts.", e)
            }
        }

    }
}
