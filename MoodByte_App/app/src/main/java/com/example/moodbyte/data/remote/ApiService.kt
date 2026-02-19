package com.example.moodbyte.data.remote

import com.example.moodbyte.data.remote.dtos.ArticuloDto
import com.example.moodbyte.data.remote.dtos.EjercicioDto
import com.example.moodbyte.data.remote.dtos.EntradaDto
import com.example.moodbyte.data.remote.dtos.EstadoDto
import com.example.moodbyte.data.remote.dtos.FraseDto
import com.example.moodbyte.data.remote.dtos.RegistroDto
import com.example.moodbyte.data.remote.dtos.UsuarioDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    /**
     * Metodos de usuario
     **/
    @GET("usuario")
    suspend fun getUsuarios(): List<UsuarioDto>

    @GET("usuario/{id}")
    suspend fun getUsuarioById(@Path("id") id: Long): UsuarioDto

    //Articulos
    @GET("articulo")
    suspend fun getArticulos(): List<ArticuloDto>

    @GET("articulo/{id}")
    suspend fun getArticuloById(@Path("id") id:Long) :ArticuloDto
    //Ejercicio
    @GET("ejercicio")
    suspend fun getEjercicios() : List<EjercicioDto>

    @GET("ejercicio/{id}")
    suspend fun getEjercicioById(@Path("id") id:Long) : EjercicioDto

    //Entrada
    @GET("entrada")
    suspend fun getEntradas(): List<EntradaDto>
    @GET("entrada/{id}")
    suspend fun getEntradaById(@Path("id")id:Long): EntradaDto

    //Estado
    @GET("estado")
    suspend fun getEstados(): List<EstadoDto>

    @GET("estado/{id}")
    suspend fun getEstadoById(@Path("id")id:Long): EstadoDto

    //Frases
    @GET("frase")
    suspend fun getFrases(): List<FraseDto>

    @GET("frase/{id}")
    suspend fun getFraseById(@Path("id")id:Long): FraseDto

    //Registro
    @GET("registro")
    suspend fun getRegistros():List<RegistroDto>

    @GET("registro/{id}")
    suspend fun getRegistroById(@Path("id")id:Long): RegistroDto
}