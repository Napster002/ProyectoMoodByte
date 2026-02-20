package com.example.moodbyte.data.remote.dtos

import com.example.moodbyte.data.local.entities.RegistroEntity
import java.time.LocalDate

data class RegistroDto(
    val puntuacion: Int,
    val fechaRegistro: String,
    val id_usuario: Long?
)
fun RegistroDto.toEntity() = RegistroEntity(
    puntuacion = puntuacion,
    fechaRegistro = fechaRegistro,
    id_usuario = id_usuario
)
