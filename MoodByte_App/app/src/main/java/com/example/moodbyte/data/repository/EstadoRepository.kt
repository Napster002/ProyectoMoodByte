package com.example.moodbyte.data.repository

import com.example.moodbyte.data.local.daos.EstadoDao
import com.example.moodbyte.data.local.entities.toDomain
import com.example.moodbyte.data.remote.ApiService
import com.example.moodbyte.data.remote.dtos.toEntity
import com.example.moodbyte.domain.model.Estado
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class EstadoRepository(
    private val api: ApiService,
    private val dao: EstadoDao
) {
    val estados: Flow<List<Estado>> = flow {
        emit(dao.getAll().map { it.toDomain() })
    }

    suspend fun refreshEstados(){
        val estadosApi=api.getEstados()
        dao.insertAll(estadosApi.map { it.toEntity() })
    }
}