package com.example.moodbyte.data.remote.dtos

import com.example.moodbyte.data.local.entities.FraseEntity

data class FraseDto(
    val id:Long,
    val frase:String,
    val puntuacion:Int
)

fun FraseDto.toEntity()= FraseEntity(
    id = id,
    frase = frase,
    puntuacion = puntuacion
)