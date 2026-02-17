package com.example.moodbyte.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    /**
     * Metodos de usuario
     **/
    @GET("usuarios")
    suspend fun getUsuarios(): List<UsuarioDto>

    @GET("usuarios/{id}")
    suspend fun getUsuarioById(@Path("id") id: Long): UsuarioDto
}