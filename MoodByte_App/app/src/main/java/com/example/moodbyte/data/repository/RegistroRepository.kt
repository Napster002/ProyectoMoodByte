package com.example.moodbyte.data.repository

import android.util.Log
import com.example.moodbyte.data.local.daos.RegistroDao
import com.example.moodbyte.data.local.entities.toDomain
import com.example.moodbyte.data.remote.ApiService
import com.example.moodbyte.data.remote.dtos.RegistroDto
import com.example.moodbyte.data.remote.dtos.toEntity
import com.example.moodbyte.domain.model.Registro
import com.example.moodbyte.domain.model.toDto
import com.example.moodbyte.domain.model.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RegistroRepository(
    private val dao: RegistroDao,
    private val api: ApiService
) {
    val registros : Flow<List<Registro>> = flow{
        emit( dao.getAll().map { it.toDomain() })
    }

    suspend fun insertarRegistro(registro: Registro){
        dao.insert(registro.toEntity())
        Log.i("API",registro.toDto().idUsuario.toString())
        api.insertarRegistro(registro.toDto())
    }
    suspend fun refreshRegistros(){
        val registrosApi=api.getRegistros()
        dao.insertAll(registrosApi.map { it.toEntity() })
    }
}