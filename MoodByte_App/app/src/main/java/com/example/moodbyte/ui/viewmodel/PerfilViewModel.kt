package com.example.moodbyte.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.moodbyte.data.local.daos.UsuarioDao
import com.example.moodbyte.data.remote.ApiService
import com.example.moodbyte.domain.model.toDto
import com.example.moodbyte.domain.model.toEntity

class PerfilViewModel(
    private val session: UsuarioSesionViewModel,
    private val api: ApiService,
    private val dao: UsuarioDao
): ViewModel() {
    val usuario=session.usuario.asLiveData()

    suspend fun actualizarUsuario(nombre:String, nomUsu:String, password:String) {
        val usuarioActual=usuario.value?:return
        val usuarioEdit = usuarioActual.copy(
            nombreUsuario = nomUsu,
            nombreCompleto = nombre,
            password = password
        )
        try {
                api.insertUsuario(usuarioEdit.toDto())
                dao.insert(usuarioEdit.toEntity())
                session.setusuario(usuarioEdit)
        } catch (e: Exception) {
        }
    }
    fun cerrarSesion(){
        session.setusuario(null)
    }


}
