package com.example.moodbyte.data.repository

import com.example.moodbyte.data.local.daos.ArticuloDao
import com.example.moodbyte.data.local.entities.toDomain
import com.example.moodbyte.data.remote.ApiService
import com.example.moodbyte.data.remote.dtos.toEntity
import com.example.moodbyte.domain.model.Articulo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class ArticuloRepository (
    private val api:ApiService,
    private val dao: ArticuloDao
) {

    suspend fun getArticulos(): List<Articulo>{
        return dao.getAll().map { it.toDomain() }
    }


    suspend fun refreshArticulos(){
        val articulosApi=api.getArticulos()
        dao.clearAll()
        dao.insertAll(articulosApi.map { it.toEntity() })
    }
}