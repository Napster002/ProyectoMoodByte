package com.example.moodbyte.ui.viewmodel

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moodbyte.data.local.daos.UsuarioDao
import com.example.moodbyte.data.local.entities.UsuarioEntity
import com.example.moodbyte.data.local.entities.toDomain
import com.example.moodbyte.data.remote.ApiService
import com.example.moodbyte.domain.model.toDto
import com.example.moodbyte.domain.model.toEntity
import kotlinx.coroutines.launch

class PerfilViewModel(
    private val session: UsuarioSesionViewModel,
    private val api: ApiService,
    private val dao: UsuarioDao
): ViewModel() {
    val usuario=session.usuario.value

    suspend fun actualizarUsuario(nombre:String, nomUsu:String, password:String){
        val usuarioEdit = usuario?.copy(
            nombreUsuario = nomUsu,
            nombreCompleto = nombre,
            password = password )
        try{
                usuarioEdit?.let {
                    api.insertUsuario(it.toDto())
                    dao.insert(it.toEntity())
                    session.setusuario(usuarioEdit)
                }
        }catch(e:Exception){
        }
    }


}
