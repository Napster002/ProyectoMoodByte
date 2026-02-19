package com.example.moodbyte.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.moodbyte.domain.model.Entrada
import java.time.LocalDate

@Entity(tableName = "entradas")
data class EntradaEntity(
    @PrimaryKey
    val id: Long,
    val texto: String,
    val fechaEntrada: LocalDate
)

fun EntradaEntity.toDomain() = Entrada(
    id = id,
    texto = texto,
    fechaEntrada = fechaEntrada
)