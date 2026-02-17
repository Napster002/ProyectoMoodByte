package com.example.moodbyte.data.repository

import com.example.moodbyte.data.local.UsuarioDao
import com.example.moodbyte.data.local.toDomain
import com.example.moodbyte.data.remote.ApiService
import com.example.moodbyte.data.remote.toEntity
import com.example.moodbyte.domain.model.Usuario
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

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
}