package com.example.moodbyte.domain.model

import com.example.moodbyte.data.local.entities.RegistroEntity
import com.example.moodbyte.data.remote.dtos.RegistroDto
import java.time.LocalDate

data class Registro(
    val id: Long?=null,
    val puntuacion: Int,
    val fechaRegistro: LocalDate,
    val id_usuario: Long?
)
fun Registro.toEntity() = RegistroEntity(
    puntuacion = puntuacion,
    fechaRegistro = fechaRegistro.toString(),
    id_usuario = id_usuario
)

fun Registro.toDto() = RegistroDto(
    puntuacion = puntuacion,
    fechaRegistro = fechaRegistro.toString(),
    id_usuario = id_usuario
)


