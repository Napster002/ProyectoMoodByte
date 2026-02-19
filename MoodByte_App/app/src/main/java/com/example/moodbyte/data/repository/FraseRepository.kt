package com.example.moodbyte.data.repository

import com.example.moodbyte.data.local.daos.FraseDao
import com.example.moodbyte.data.local.entities.toDomain
import com.example.moodbyte.data.remote.ApiService
import com.example.moodbyte.data.remote.dtos.toEntity
import com.example.moodbyte.domain.model.Frase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FraseRepository(
    private val api: ApiService,
    private val dao: FraseDao
) {
    val frases: Flow<List<Frase>> = flow{
        emit( dao.getAll().map { it.toDomain() })
    }
    suspend fun refreshFrases(){
        val frasesApi=api.getFrases()
        dao.insertAll(frasesApi.map { it.toEntity() })
    }
}