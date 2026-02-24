package com.example.moodbyte.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moodbyte.data.remote.dtos.DiarioDto
import com.example.moodbyte.domain.model.Usuario
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class UsuarioSesionViewModel : ViewModel(){
    private val _usuario = MutableStateFlow<Usuario?>(null)
    val usuario= _usuario.asStateFlow()

    private val _diario = MutableStateFlow<DiarioDto?>(null)
    val diario = _diario.asStateFlow()

    fun setusuario(usuario:Usuario?){
        _usuario.value=usuario
    }

    fun setDiario(d: DiarioDto) {
        _diario.value = d
    }
}