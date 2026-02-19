package com.example.moodbyte.data.repository

import com.example.moodbyte.data.local.daos.EjercicioDao
import com.example.moodbyte.data.local.entities.toDomain
import com.example.moodbyte.data.remote.ApiService
import com.example.moodbyte.data.remote.dtos.toEntity
import com.example.moodbyte.domain.model.Ejercicio
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class EjercicioRepository(
    private val api: ApiService,
    private val dao: EjercicioDao
) {
    val ejercicios: Flow<List<Ejercicio>> = flow{
        emit( dao.getAll().map { it.toDomain() })
    }

    suspend fun refreshEjercicios(){
        val ejercicios=api.getEjercicios()
        dao.insertAll(ejercicios.map { it.toEntity() })
    }
}