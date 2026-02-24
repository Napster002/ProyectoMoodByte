package com.example.moodbyte.domain.model

import java.time.LocalTime

data class Ejercicio(
    val id:Long,
    val titulo:String,
    val descripcion:String,
    val recursoUrl:String,
    val duracion: LocalTime,
    val estado_id: Long?=null
)
