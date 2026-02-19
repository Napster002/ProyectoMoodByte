package com.example.moodbyte.data.remote.dtos

import androidx.room.PrimaryKey
import com.example.moodbyte.data.local.entities.RegistroEntity
import com.example.moodbyte.domain.model.Registro
import java.time.LocalDate

data class RegistroDto(
    val id:Long,
    val puntuacion:Int,
    val fechaRegistro: LocalDate,
    val id_usuario:Long
)

fun RegistroDto.toEntity()= RegistroEntity(
    id=id,
    puntuacion=puntuacion,
    fechaRegistro=fechaRegistro,
    id_usuario=id_usuario
)