package com.example.moodbyte.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moodbyte.data.repository.EjercicioRepository
import com.example.moodbyte.domain.model.Ejercicio
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

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
}