package com.example.moodbyte.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moodbyte.data.repository.ArticuloRepository
import com.example.moodbyte.domain.model.Articulo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArticulosViewModel(
    private val repo: ArticuloRepository
): ViewModel() {
    private val _articulos = MutableStateFlow<List<Articulo>>(emptyList())
    val articulos = _articulos.asStateFlow()

    init { cargarArticulos() }

    private fun cargarArticulos() {
        viewModelScope.launch {
            repo.refreshArticulos()
            val listaArticulo=repo.getArticulos()
            _articulos.value= listaArticulo
        }
    }
}