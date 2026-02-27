package com.example.moodbyte.data.remote.dtos

import androidx.room.PrimaryKey
import com.example.moodbyte.data.local.entities.EstadoEntity
import com.example.moodbyte.domain.model.Estado

data class EstadoDto(
    @PrimaryKey
    val id:Long,
    val nombre:String
)

fun EstadoDto.toEntity()= EstadoEntity(
    id = id,
    nombre = nombre
)