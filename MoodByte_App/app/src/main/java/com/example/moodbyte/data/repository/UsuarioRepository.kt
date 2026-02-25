package com.example.moodbyte.data.repository

import com.example.moodbyte.data.local.daos.UsuarioDao
import com.example.moodbyte.data.local.entities.UsuarioEntity
import com.example.moodbyte.data.local.entities.toDomain
import com.example.moodbyte.data.remote.ApiService
import com.example.moodbyte.data.remote.dtos.toEntity
import com.example.moodbyte.domain.model.Usuario
import com.example.moodbyte.domain.model.toDto
import com.example.moodbyte.domain.model.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UsuarioRepository(
    private val api: ApiService,
    private val dao: UsuarioDao
) {
    val usuarios: Flow<List<Usuario>> =
        flow {
            emit(dao.getAll().map { it.toDomain() })
        }
    suspend fun refreshUsuarios() {
        val usuariosApi = api.getUsuarios()
        dao.insertAll(usuariosApi.map { it.toEntity() })
    }
    suspend fun insertarusuario(usuario: Usuario){
        dao.insert(usuario.toEntity())
        api.insertUsuario(usuario.toDto())
    }
    suspend fun actualizarUsuario(usuario:Usuario){
        dao.insert(usuario.toEntity())
        api.actualizarUsuario(usuario.id!!,usuario.toDto())
    }
}