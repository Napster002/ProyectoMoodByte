package com.example.moodbyte.data.remote.dtos

import androidx.room.PrimaryKey
import com.example.moodbyte.data.local.entities.ArticuloEntity
import com.example.moodbyte.domain.model.Articulo

data class ArticuloDto(
val id:Long,
val titulo:String,
val subtitulo:String,
val imagen:String,
val enlace:String
)

fun ArticuloDto.toEntity() = ArticuloEntity(
    id = id,
    titulo = titulo,
    subtitulo=subtitulo,
    imagen=imagen,
    enlace=enlace
)