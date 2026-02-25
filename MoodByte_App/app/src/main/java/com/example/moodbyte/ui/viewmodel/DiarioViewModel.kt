package com.example.moodbyte.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moodbyte.data.repository.EntradaRepository
import com.example.moodbyte.domain.model.Entrada
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalDate

class DiarioViewModel(
    private val session: UsuarioSesionViewModel,
    private val repo: EntradaRepository
) : ViewModel() {

    val usuario = session.usuario

    val entradas = repo.entradas
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    init {
        viewModelScope.launch {
            usuario.collect { user ->
                if (user != null) {
                    repo.refreshEntradas(user.id)
                }
            }
        }
    }

    fun getEntradaFor(date: LocalDate): Entrada? {
        return entradas.value.firstOrNull { it.fechaEntrada == date }
    }

    fun saveEntrada(date: LocalDate, text: String) {
        viewModelScope.launch {
            val user = usuario.value ?: return@launch

            val existing = getEntradaFor(date)

            val entrada = Entrada(
                id = existing?.id ?: 0L,
                texto = text,
                fechaEntrada = date,
                1
            )

            repo.saveEntrada(entrada)
            repo.refreshEntradas(user.id)
        }
    }
}