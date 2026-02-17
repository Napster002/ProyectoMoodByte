package com.example.moodbyte.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.moodbyte.data.repository.UsuarioRepository
import kotlinx.coroutines.launch

class UsuarioViewModel(
    private val repository: UsuarioRepository
) : ViewModel() {

    val usuarios = repository.usuarios.asLiveData()

    fun refrescar() {
        viewModelScope.launch {
            repository.refreshUsuarios()
        }
    }
}