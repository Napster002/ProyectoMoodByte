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

    fun sumarExp(cantidad: Int){
        val usuarioActual = _usuario.value ?: return
        var nuevaExp = usuarioActual.expAcumulada + cantidad
        var nuevoNivel = usuarioActual.nivel

        val expNecesaria = 100 * usuarioActual.nivel
        if (nuevaExp >= expNecesaria) {
            nuevaExp -= expNecesaria
            nuevoNivel++
        }
        val usuarioActualizado = usuarioActual.copy(
            nivel = nuevoNivel,
            expAcumulada = nuevaExp
        )
        _usuario.value = usuarioActualizado
    }
}