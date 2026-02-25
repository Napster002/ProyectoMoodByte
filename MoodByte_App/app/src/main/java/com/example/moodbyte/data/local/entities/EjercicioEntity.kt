package com.example.moodbyte.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.moodbyte.domain.model.Ejercicio
import java.time.LocalTime
import kotlin.Long

@Entity(tableName = "ejercicios",
    foreignKeys = [
        ForeignKey(
            entity = EstadoEntity::class,
            parentColumns = ["id"],
            childColumns = ["estado_id"]
        )
    ],
    indices=[Index("estado_id")])
data class EjercicioEntity(
    @PrimaryKey
    val id:Long,
    val titulo:String,
    val descripcion:String,
    val recursoUrl:String,
    val duracion: LocalTime,
    @ColumnInfo(name = "estado_id")
    val estado_id: Long,
    val nombre: String
)

fun EjercicioEntity.toDomain()= Ejercicio(
    id = id,
    titulo = titulo,
    descripcion = descripcion,
    recursoUrl = recursoUrl,
    duracion = duracion,
    estado_id = estado_id,
    nombre = nombre
)