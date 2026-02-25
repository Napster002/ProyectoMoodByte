package com.example.moodbyte.data.remote.dtos

import androidx.room.PrimaryKey
import com.example.moodbyte.data.local.entities.EjercicioEntity
import com.example.moodbyte.domain.model.Ejercicio
import java.time.LocalTime

data class EjercicioDto(
    val id:Long,
    val titulo:String,
    val descripcion:String,
    val recursoUrl:String,
    val duracion: LocalTime,
    val estado: EstadoDto? = null
)

fun EjercicioDto.toEntity()= EjercicioEntity(
    id = id,
    titulo = titulo,
    descripcion = descripcion,
    recursoUrl = recursoUrl,
    duracion = duracion,
    estado_id = estado?.id ?: 1L
)