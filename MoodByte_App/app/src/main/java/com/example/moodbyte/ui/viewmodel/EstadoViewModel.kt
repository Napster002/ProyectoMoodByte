package com.example.moodbyte.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moodbyte.data.repository.EstadoRepository
import com.example.moodbyte.domain.model.Estado
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EstadoViewModel(
   private val repo: EstadoRepository): ViewModel() {
   private val _estados = MutableStateFlow<List<Estado>>(emptyList())
   val estados = _estados.asStateFlow()

   init{CargarEstados()}

   private fun CargarEstados(){
      viewModelScope.launch {
         repo.refreshEstados()
         var listaEjercicio= repo.getEstados()
         _estados.value=listaEjercicio
      }
   }
}