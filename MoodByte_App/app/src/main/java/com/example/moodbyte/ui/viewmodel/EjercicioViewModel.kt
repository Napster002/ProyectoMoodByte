package com.example.moodbyte.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moodbyte.data.local.entities.EjercicioEntity
import com.example.moodbyte.data.repository.EjercicioRepository
import com.example.moodbyte.data.repository.EstadoRepository
import com.example.moodbyte.domain.model.Ejercicio
import com.example.moodbyte.domain.model.Estado
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalTime

class EjercicioViewModel(
    private val repo: EjercicioRepository,
    private val repoe: EstadoRepository): ViewModel() {
    private val _ejercicios=MutableStateFlow<List<Ejercicio>>(emptyList())
    val ejercicios= _ejercicios.asStateFlow()
    private val _estados= MutableStateFlow<List<Estado>>(emptyList())
    init{cargarEjercicios()}

    private fun cargarEjercicios(){
        viewModelScope.launch {
            repo.refreshEjercicios()
            var listaEjercicio= repo.getEjercicios()
            _ejercicios.value=listaEjercicio
        }
    }
//    fun cargarEjerciciosPorEstado(nombreEstado: String) {
//        viewModelScope.launch {
//            val listaFiltrada = repo.cargarEjerciciosPorEstado(nombreEstado)
//            _ejercicios.value = listaFiltrada
//        }
//    }
     fun recargarEjercicios(){
        viewModelScope.launch {
            repo.refreshEjercicios()
            var listaEjercicio= repo.getEjercicios()
            _ejercicios.value=listaEjercicio
        }
    }
    fun cargarEjerciciosPorEstado(nombreEstado: String){
        viewModelScope.launch {
            val listaEntity: List<EjercicioEntity> = repo.getEjerciciosPorEstado(nombreEstado)

// Convertir cada EjercicioEntity a Ejercicio
            val lista: List<Ejercicio> = listaEntity.map { entity ->
                Ejercicio(
                    // asigna aquí las propiedades, ejemplo:
                    id = entity.id,
                    titulo = entity.titulo,
                    descripcion =entity.descripcion,
                    recursoUrl = entity.recursoUrl,
                    duracion = entity.duracion,
                    estado_id = entity.estado_id
                )
            }
            _ejercicios.value = lista
        }
    }
    fun insertarEjercicio(
        titulo: String,
        descripcion: String,
        recursoUrl: String,
        duracion: String, // formato "HH:MM:SS"
        estadoId: Long
    ) {
        viewModelScope.launch {
            // Convertimos duración a LocalTime
            val duracionParsed = try {
                LocalTime.parse(duracion)
            } catch (e: Exception) {
                LocalTime.of(0, 5, 0)
            }

            // Creamos el entity
            val nuevoEjercicio = EjercicioEntity(
                id = 0,
                titulo = titulo,
                descripcion = descripcion,
                recursoUrl = recursoUrl,
                duracion = duracionParsed,
                estado_id = estadoId,
                nombre="nombre"
            )

            // Insertamos en la base de datos
            repo.insertarEjercicio(nuevoEjercicio)

            // Refrescamos la lista en Compose
            _ejercicios.value = repo.cargarEjercicios()
        }
    }
}