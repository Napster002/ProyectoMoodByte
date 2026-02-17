package com.example.moodbyte.domain.model

import java.time.LocalDate

data class Usuario(
    val id: Long,
    val nombreCompleto: String,
    val nombreUsuario: String,
    val edad: Int,
    val genero: Genero,
    val tipoUsuario: TipoUsuario,
    val fechaRegistro: LocalDate,
    val fechaNacimiento: LocalDate,
    val nivel: Int,
    val expAcumulada: Double
)

