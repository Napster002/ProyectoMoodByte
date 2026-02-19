package com.example.moodbyte.data.repository

import com.example.moodbyte.data.local.daos.EntradaDao
import com.example.moodbyte.data.local.entities.toDomain
import com.example.moodbyte.data.remote.ApiService
import com.example.moodbyte.data.remote.dtos.toEntity
import com.example.moodbyte.domain.model.Entrada
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class EntradaRepository(
    private val api: ApiService,
    private val dao: EntradaDao
) {
    val entradas: Flow<List<Entrada>> = flow{
        emit( dao.getAll().map { it.toDomain() })
    }

    suspend fun refreshEntradas(){
        val entradasApi=api.getEntradas()
        dao.insertAll(entradasApi.map { it.toEntity() })
    }
}