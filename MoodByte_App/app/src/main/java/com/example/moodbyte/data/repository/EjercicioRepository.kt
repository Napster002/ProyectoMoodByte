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
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.util.Collections.list

class EjercicioRepository(
    private val api: ApiService,
    private val dao: EjercicioDao
) {
    fun ejerciciosdeEstado():Flow<List<Ejercicio>> =
        dao.getAll().map { list -> list.map { it.toDomain() } }

    suspend fun refreshEjercicios(){
        val ejercicios=api.getEjercicios()
        dao.insertAll(ejercicios.map { it.toEntity() })
    }
    fun cargarEjerciciosPorEstado(idEstado:Long): Flow<List<Ejercicio>> =
        dao.getByNombreEstado(idEstado).map { list -> list.map{it.toDomain()}
        }

}