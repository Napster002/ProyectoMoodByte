package com.example.moodbyte.domain.model

import com.example.moodbyte.data.remote.dtos.EntradaDto
import java.time.LocalDate

data class Entrada(
    val id:Long,
    val texto:String,
    val fechaEntrada: LocalDate,
    val idDiario: Long
    )

fun Entrada.toDto() = EntradaDto(
    id = id,
    texto = texto,
    fechaEntrada = fechaEntrada.toString(),
    idDiario = idDiario
)
