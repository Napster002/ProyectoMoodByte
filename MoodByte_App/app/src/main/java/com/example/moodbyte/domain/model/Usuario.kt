package com.example.moodbyte.domain.model

import com.example.moodbyte.data.local.entities.UsuarioEntity
import com.example.moodbyte.data.remote.dtos.UsuarioDto
import java.time.LocalDate
import kotlin.math.exp

data class Usuario(
    val id: Long? = null,
    var nombreCompleto: String,
    var nombreUsuario: String,
    var password:String,
    val edad: Int,
    val genero: Genero,
    val tipoUsuario: TipoUsuario,
    val fechaRegistro: LocalDate,
    val fechaNacimiento: LocalDate,
    val nivel: Int,
    val expAcumulada: Double
)

fun Usuario.toDto()= UsuarioDto(
    id=id,
    nombreCompleto=nombreCompleto,
    nombreUsuario=nombreUsuario,
    password=password,
    edad=edad,
    genero=genero.toString(),
    tipoUsuario=tipoUsuario.toString(),
    fechaRegistro=fechaRegistro.toString(),
    fechaNacimiento=fechaNacimiento.toString(),
    nivel=nivel,
    expAcumulada= expAcumulada
)

fun Usuario.toEntity()= UsuarioEntity(
    id = id,
    nombreCompleto = nombreCompleto,
    nombreUsuario = nombreUsuario,
    password = password,
    edad = edad,
    genero = genero.toString(),
    tipoUsuario = tipoUsuario.toString(),
    fechaRegistro = fechaRegistro.toString(),
    fechaNacimiento = fechaNacimiento.toString(),
    nivel = nivel,
    expAcumulada = expAcumulada
)

