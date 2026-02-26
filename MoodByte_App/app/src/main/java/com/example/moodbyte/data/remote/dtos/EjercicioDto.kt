package com.example.moodbyte.data.remote.dtos

import com.example.moodbyte.data.local.entities.EjercicioEntity
import java.time.LocalTime

data class EjercicioDto(
    val id:Long,
    val titulo:String,
    val descripcion:String,
    val recursoUrl:String,
    val duracion: LocalTime,
    val estadoid: Long
)

fun EjercicioDto.toEntity()= EjercicioEntity(
    id = id,
    titulo = titulo,
    descripcion = descripcion,
    recursoUrl = recursoUrl,
    duracion = duracion,
    estadoid = estadoid
)