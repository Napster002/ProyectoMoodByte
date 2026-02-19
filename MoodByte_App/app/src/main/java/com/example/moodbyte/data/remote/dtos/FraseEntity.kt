package com.example.moodbyte.data.remote.dtos

import androidx.room.PrimaryKey
import com.example.moodbyte.data.local.entities.FraseEntity
import com.example.moodbyte.domain.model.Frase

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