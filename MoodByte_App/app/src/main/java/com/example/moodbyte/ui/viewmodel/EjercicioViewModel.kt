package com.example.moodbyte.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moodbyte.data.local.entities.EjercicioEntity
import com.example.moodbyte.data.repository.EjercicioRepository
import com.example.moodbyte.domain.model.Ejercicio
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalTime

class EjercicioViewModel(
    private val repo: EjercicioRepository): ViewModel() {
    private val _ejercicios=MutableStateFlow<List<Ejercicio>>(emptyList())
    val ejercicios= _ejercicios.asStateFlow()

    init{cargarEjercicios()}

    private fun cargarEjercicios(){
        viewModelScope.launch {
            repo.refreshEjercicios()
            var listaEjercicio= repo.getEjercicios()
            _ejercicios.value=listaEjercicio
        }
    }
    fun cargarEjerciciosPorEstado(nombreEstado: String) {
        viewModelScope.launch {
            val listaFiltrada = repo.cargarEjerciciosPorEstado(nombreEstado)// repo debe tener función suspend
            _ejercicios.value = listaFiltrada
        }
    }
     fun recargarEjercicios(){
        viewModelScope.launch {
            repo.refreshEjercicios()
            var listaEjercicio= repo.getEjercicios()
            _ejercicios.value=listaEjercicio
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
                estado_id = estadoId
            )

            // Insertamos en la base de datos
            repo.insertarEjercicio(nuevoEjercicio)

            // Refrescamos la lista en Compose
            _ejercicios.value = repo.cargarEjercicios()
        }
    }
}