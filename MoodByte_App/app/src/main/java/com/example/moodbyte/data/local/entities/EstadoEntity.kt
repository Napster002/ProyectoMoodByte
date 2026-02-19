package com.example.moodbyte.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.moodbyte.domain.model.Estado

@Entity(tableName = "estados")
data class EstadoEntity(
    @PrimaryKey
    val id:Long,
    val nombre:String
)

fun EstadoEntity.toDomain()= Estado(
    id = id,
    nombre = nombre
)