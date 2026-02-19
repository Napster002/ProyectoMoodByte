package com.example.moodbyte.data.repository

import com.example.moodbyte.data.local.daos.RegistroDao
import com.example.moodbyte.data.local.entities.toDomain
import com.example.moodbyte.data.remote.ApiService
import com.example.moodbyte.data.remote.dtos.toEntity
import com.example.moodbyte.domain.model.Registro
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RegistroRepository(
    private val api: ApiService,
    private val dao: RegistroDao
) {
    val registros : Flow<List<Registro>> = flow{
        emit( dao.getAll().map { it.toDomain() })
    }

    suspend fun refreshRegistros(){
        val registrosApi=api.getRegistros()
        dao.insertAll(registrosApi.map { it.toEntity() })
    }
}