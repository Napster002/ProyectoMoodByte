package com.example.moodbyte.domain.model

import androidx.room.Entity
import java.time.LocalDate

data class Registro(
   val id:Long,
    val puntuacion:Int,
    val fechaRegistro: LocalDate,
    val id_usuario:Long
)
