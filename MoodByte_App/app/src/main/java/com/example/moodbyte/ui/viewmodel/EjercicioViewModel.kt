package com.example.moodbyte.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.moodbyte.data.local.entities.EjercicioEntity
import com.example.moodbyte.data.repository.EjercicioRepository
import com.example.moodbyte.domain.model.Ejercicio
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalTime

class EjercicioViewModel(
    private val repo: EjercicioRepository): ViewModel() {
    private val _estadoId = MutableStateFlow<Long?>(null)
    init {
        refreshEjercicios()
    }
    val ejercicios: StateFlow<List<Ejercicio>> = _estadoId.flatMapLatest { id ->
        if(id ==null){
            repo.ejerciciosdeEstado()
        }else{
            repo.cargarEjerciciosPorEstado(id)
        }
    } .stateIn(scope = viewModelScope, started = SharingStarted.Eagerly,
        initialValue = emptyList())

    fun cargarEjerciciosPorEstado(idEstado:Long) {
        _estadoId.value= idEstado
    }
    fun recargarEjercicios(){
        _estadoId.value=null
    }
    fun refreshEjercicios(){
        viewModelScope.launch {
            repo.refreshEjercicios()
        }
    }
}