package com.example.moodbyte.data.repository

import androidx.lifecycle.viewModelScope
import com.example.moodbyte.data.local.daos.EjercicioDao
import com.example.moodbyte.data.local.entities.EjercicioEntity
import com.example.moodbyte.data.local.entities.toDomain
import com.example.moodbyte.data.remote.ApiService
import com.example.moodbyte.data.remote.dtos.toEntity
import com.example.moodbyte.domain.model.Ejercicio
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class EjercicioRepository(
    private val api: ApiService,
    private val dao: EjercicioDao
) {
    val ejercicios: Flow<List<Ejercicio>> = flow{
        emit( dao.getAll().map { it.toDomain() })
    }
    suspend fun getEjercicios(): List<Ejercicio>{
        return dao.getAll().map { it.toDomain() }
    }
    suspend fun refreshEjercicios(){
        dao.clearAll()
        val ejercicios=api.getEjercicios()
        dao.insertAll(ejercicios.map { it.toEntity() })
    }
    suspend fun cargarEjerciciosPorEstado(nombreEstado: String): List<Ejercicio> {
        return dao.getByNombreEstado(nombreEstado).map { it.toDomain() }
    }
    suspend fun cargarEjercicios(): List<Ejercicio>{
        return dao.getAll().map { it.toDomain() }
    }
    suspend fun insertarEjercicio(ejercicio: EjercicioEntity) {
        dao.insert(ejercicio)
    }
}