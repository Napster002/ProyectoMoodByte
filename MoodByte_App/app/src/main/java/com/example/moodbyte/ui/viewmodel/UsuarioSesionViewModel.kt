package com.example.moodbyte.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.moodbyte.domain.model.Usuario
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class UsuarioSesionViewModel : ViewModel(){
    private val _usuario = MutableStateFlow<Usuario?>(null)
    val usuario= _usuario.asStateFlow()

    fun setusuario(usuario:Usuario?){
        _usuario.value=usuario
    }
}