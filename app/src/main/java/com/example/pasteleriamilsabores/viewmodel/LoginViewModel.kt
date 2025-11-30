package com.example.pasteleriamilsabores.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.pasteleriamilsabores.data.MilSaboresDatabase
import com.example.pasteleriamilsabores.model.Usuario


class LoginViewModel(application: Application): AndroidViewModel(application) {
    private val database = MilSaboresDatabase.getDatabase(application)
    private val usuarioDao = database.usuarioDao()

    suspend fun login(nombre: String, contrasena: String): Usuario? {
        return usuarioDao.login(nombre, contrasena)
    }

    suspend fun registrousuario(usuario: Usuario): Long {
        return usuarioDao.insertar(usuario)
    }

    suspend fun obtenerUsuarioPorId(id: Int): Usuario {
        return usuarioDao.obtenerPorId(id)
    }
}
