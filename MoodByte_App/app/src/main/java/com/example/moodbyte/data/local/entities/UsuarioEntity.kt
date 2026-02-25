package com.example.moodbyte.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.moodbyte.domain.model.Genero
import com.example.moodbyte.domain.model.TipoUsuario
import com.example.moodbyte.domain.model.Usuario
import java.time.LocalDate

@Entity(tableName = "usuarios")
data class UsuarioEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long?=0,
    val nombreCompleto: String,
    val nombreUsuario: String,
    val password:String,
    val edad: Int,
    val genero: String,
    val tipoUsuario: String,
    val fechaRegistro: String,
    val fechaNacimiento: String,
    val nivel: Int,
    val expAcumulada: Double
)


fun UsuarioEntity.toDomain() = Usuario(
    id = id,
    nombreCompleto = nombreCompleto,
    nombreUsuario = nombreUsuario,
    password=password,
    edad = edad,
    genero = Genero.valueOf(genero),
    tipoUsuario = TipoUsuario.valueOf(tipoUsuario),
    fechaRegistro = LocalDate.parse(fechaRegistro),
    fechaNacimiento = LocalDate.parse(fechaNacimiento),
    nivel = nivel,
    expAcumulada = expAcumulada
)