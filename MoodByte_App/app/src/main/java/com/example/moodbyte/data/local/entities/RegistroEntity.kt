package com.example.moodbyte.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.moodbyte.domain.model.Registro
import java.time.LocalDate

@Entity(tableName = "registros")
data class RegistroEntity(
    @PrimaryKey
    val id:Long,
    val puntuacion:Int,
    val fechaRegistro: LocalDate,
    val id_usuario:Long
)

fun RegistroEntity.toDomain()= Registro(
    id=id,
    puntuacion=puntuacion,
    fechaRegistro=fechaRegistro,
    id_usuario=id_usuario
)
