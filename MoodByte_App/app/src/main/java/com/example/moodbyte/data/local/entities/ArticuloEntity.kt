package com.example.moodbyte.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.moodbyte.domain.model.Articulo

@Entity(tableName = "articulos")
data class ArticuloEntity(
    @PrimaryKey
    val id:Long,
    val titulo:String,
    val subtitulo:String,
    val imagen:String,
    val enlace:String
)

fun ArticuloEntity.toDomain() = Articulo(
    id = id,
    titulo = titulo,
    subtitulo=subtitulo,
    imagen=imagen,
    enlace=enlace
    )