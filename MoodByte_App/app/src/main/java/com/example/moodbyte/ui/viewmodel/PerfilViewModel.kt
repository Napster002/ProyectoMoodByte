package com.example.moodbyte.ui.viewmodel

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel

class PerfilViewModel(
    private val session: UsuarioSesionViewModel
): ViewModel() {
    val usuario=session.usuario.value

    fun actualizarUsuario(nombre:String,nomUsu:String){
        session.actualizarUsuario(nombre, nomUsu)
    }


}
