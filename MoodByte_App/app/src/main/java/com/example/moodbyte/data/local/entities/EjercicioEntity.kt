package com.example.moodbyte.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.moodbyte.domain.model.Ejercicio
import java.time.LocalTime
import kotlin.Long

@Entity(tableName = "ejercicios")
data class EjercicioEntity(
    @PrimaryKey
    val id:Long,
    val titulo:String,
    val descripcion:String,
    val recursoUrl:String,
    val duracion: LocalTime,
    @ColumnInfo(name="estado_id")
    val estadoid: Long=1L
)

fun EjercicioEntity.toDomain()= Ejercicio(
    id = id,
    titulo = titulo,
    descripcion = descripcion,
    recursoUrl = recursoUrl,
    duracion = duracion,
    estadoid = estadoid
)