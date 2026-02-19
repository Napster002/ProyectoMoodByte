package com.example.moodbyte.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.moodbyte.domain.model.Diario

@Entity(tableName = "diarios")
data class DiarioEntity(
    @PrimaryKey
    val idUsuario:Long
)

fun DiarioEntity.toDomain() = Diario(
    idUsuario = idUsuario
)