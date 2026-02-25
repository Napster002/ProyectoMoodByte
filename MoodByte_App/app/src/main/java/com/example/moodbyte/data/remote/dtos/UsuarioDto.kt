package com.example.moodbyte.data.remote.dtos

import com.example.moodbyte.data.local.entities.UsuarioEntity

data class UsuarioDto(
    val id: Long?,
    val nombreCompleto: String,
    val nombreUsuario: String,
    val password: String,
    val edad: Int,
    val genero: String,
    val tipoUsuario: String,
    val fechaRegistro: String,
    val fechaNacimiento: String,
    val nivel: Int,
    val expAcumulada: Double
)

fun UsuarioDto.toEntity() = UsuarioEntity(
    id = id,
    nombreCompleto = nombreCompleto,
    nombreUsuario = nombreUsuario,
    password = password,
    edad = edad,
    genero = genero,
    tipoUsuario = tipoUsuario,
    fechaRegistro = fechaRegistro,
    fechaNacimiento = fechaNacimiento,
    nivel = nivel,
    expAcumulada = expAcumulada
)