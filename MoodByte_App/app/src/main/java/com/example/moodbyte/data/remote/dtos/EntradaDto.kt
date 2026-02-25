package com.example.moodbyte.data.remote.dtos

import androidx.room.PrimaryKey
import com.example.moodbyte.data.local.entities.EntradaEntity
import com.example.moodbyte.domain.model.Entrada
import java.time.LocalDate

data class EntradaDto(
    val id: Long,
    val texto: String,
    val fechaEntrada: String,
    val idDiario: Long
)

fun EntradaDto.toEntity() = EntradaEntity(
    id = id,
    texto = texto,
    fechaEntrada = LocalDate.parse(fechaEntrada),
    idDiario = idDiario
)