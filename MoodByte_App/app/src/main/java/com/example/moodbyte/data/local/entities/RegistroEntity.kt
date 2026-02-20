package com.example.moodbyte.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.moodbyte.domain.model.Registro
import java.time.LocalDate

@Entity(tableName = "registros")
data class RegistroEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long =0,
    val puntuacion: Int,
    val fechaRegistro: String,
    val id_usuario: Long?
)

fun RegistroEntity.toDomain()= Registro(
    id =id,
    puntuacion =puntuacion,
    fechaRegistro =LocalDate.parse(fechaRegistro),
    id_usuario =id_usuario
)
