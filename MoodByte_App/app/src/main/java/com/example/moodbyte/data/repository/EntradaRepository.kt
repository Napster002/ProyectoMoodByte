package com.example.moodbyte.data.repository

import com.example.moodbyte.data.local.daos.EntradaDao
import com.example.moodbyte.data.local.entities.toDomain
import com.example.moodbyte.data.remote.ApiService
import com.example.moodbyte.data.remote.dtos.DiarioDto
import com.example.moodbyte.data.remote.dtos.toEntity
import com.example.moodbyte.domain.model.Entrada
import com.example.moodbyte.domain.model.toDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate

class EntradaRepository(
    private val api: ApiService,
    private val dao: EntradaDao
) {
    val entradas: Flow<List<Entrada>> =
        dao.getAllFlow().map { list -> list.map { it.toDomain() } }

    suspend fun refreshEntradas(idUsuario: Long) {
        val entradasApi = api.getEntradas(idUsuario)
        dao.insertAll(entradasApi.map { it.toEntity() })
    }

    suspend fun getEntradaByDate(date: LocalDate): Entrada? {
        return dao.getByDate(date)?.toDomain()
    }

    suspend fun saveEntrada(entrada: Entrada) {
        api.insertarEntrada(entrada.toDto())

        if (entrada.id == 0L) {
            // Crear
            dao.insert(entrada.toDto().toEntity())
        } else {
            // Editar
            dao.update(entrada.toDto().toEntity())
        }
    }

}