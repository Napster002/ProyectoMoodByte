package com.example.moodbyte.data.remote

import com.example.moodbyte.data.remote.dtos.ArticuloDto
import com.example.moodbyte.data.remote.dtos.DiarioDto
import com.example.moodbyte.data.remote.dtos.EjercicioDto
import com.example.moodbyte.data.remote.dtos.EntradaDto
import com.example.moodbyte.data.remote.dtos.EstadoDto
import com.example.moodbyte.data.remote.dtos.FraseDto
import com.example.moodbyte.data.remote.dtos.RegistroDto
import com.example.moodbyte.data.remote.dtos.UsuarioDto
import retrofit2.Response
import com.example.moodbyte.domain.model.Registro
import com.example.moodbyte.domain.model.Usuario
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    /**
     * Metodos de usuario
     **/
    @GET("usuario")
    suspend fun getUsuarios(): List<UsuarioDto>

    @GET("usuario/{id}")
    suspend fun getUsuarioById(@Path("id") id: Long): UsuarioDto

    @POST("usuario")
    suspend fun insertUsuario(@Body usuario: UsuarioDto)

    @PUT("usuario/{id}")
    suspend fun actualizarUsuario(@Path("id") id: Long, @Body usuario: UsuarioDto): Response<Unit>

    /**
     * Metodos de articulo
     **/
    @GET("articulo")
    suspend fun getArticulos(): List<ArticuloDto>

    @GET("articulo/{id}")
    suspend fun getArticuloById(@Path("id") id:Long) :ArticuloDto

    /**
     * Metodos de ejercicio
     **/
    @GET("ejercicio")
    suspend fun getEjercicios() : List<EjercicioDto>

    @GET("ejercicio/{id}")
    suspend fun getEjercicioById(@Path("id") id:Long) : EjercicioDto

    /**
     * Metodos de estado
     **/
    @GET("estado")
    suspend fun getEstados(): List<EstadoDto>

    @GET("estado/{id}")
    suspend fun getEstadoById(@Path("id")id:Long): EstadoDto

    /**
     * Metodos de frase
     **/
    @GET("frase")
    suspend fun getFrases(): List<FraseDto>

    @GET("frase/{id}")
    suspend fun getFraseById(@Path("id")id:Long): FraseDto

    /**
     * Metodos de registro
     **/
    @GET("registro")
    suspend fun getRegistros():List<RegistroDto>

    @GET("registro/{id}")
    suspend fun getRegistroById(@Path("id")id:Long): RegistroDto

    @POST("registro")
    suspend fun insertarRegistro(@Body registro: RegistroDto):Response<Void>

    /**
     * Metodos de entradas diario
     **/
    @GET("entrada/usuario/{idUsuario}")
    suspend fun getEntradas(@Path("idUsuario") idUsuario: Long): List<EntradaDto>

    @POST("entrada")
    suspend fun insertarEntrada(@Body entrada: EntradaDto)
}