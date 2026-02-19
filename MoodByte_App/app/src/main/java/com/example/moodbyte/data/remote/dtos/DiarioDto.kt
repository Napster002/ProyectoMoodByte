package com.example.moodbyte.data.remote.dtos

import androidx.room.PrimaryKey
import com.example.moodbyte.data.local.entities.DiarioEntity
import com.example.moodbyte.domain.model.Diario

data class DiarioDto(
    @PrimaryKey
    val idUsuario:Long
)

fun DiarioDto.toEntity() = DiarioEntity(
    idUsuario = idUsuario
)