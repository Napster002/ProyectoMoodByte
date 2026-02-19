package com.example.moodbyte.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.moodbyte.domain.model.Frase

@Entity(tableName = "frases")
data class FraseEntity(
    @PrimaryKey
    val id:Long,
    val frase:String,
    val puntuacion:Int
)

fun FraseEntity.toDomain()= Frase(
    id = id,
    frase = frase,
    puntuacion = puntuacion
)