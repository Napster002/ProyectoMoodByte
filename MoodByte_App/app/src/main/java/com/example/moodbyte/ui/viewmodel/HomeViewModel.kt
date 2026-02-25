package com.example.moodbyte.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moodbyte.data.remote.ApiService
import com.example.moodbyte.data.repository.RegistroRepository
import com.example.moodbyte.data.repository.UsuarioRepository
import com.example.moodbyte.domain.model.Registro
import kotlinx.coroutines.launch
import java.time.LocalDate

class HomeViewModel(
    private val session: UsuarioSesionViewModel,
    private val repo: RegistroRepository,
    private val usuRepo: UsuarioRepository
) : ViewModel() {
    val usuario = session.usuario
    val subioNivel = session.subioNivel
    fun setMood(mood: String) {
        val punt = MoodAPuntuacion(mood)
        session.setMood(punt)
        val registro: Registro = Registro(
            fechaRegistro = LocalDate.now(),
            puntuacion = punt,
            idUsuario = usuario.value!!.id!!,
        )
        viewModelScope.launch {
            repo.insertarRegistro(registro)
        }
    }

    fun actualizarUsuario(){
        viewModelScope.launch {
            usuRepo.actualizarUsuario(usuario.value!!)
        }
    }

    fun MoodAPuntuacion(mood: String): Int {
        return when (mood) {
            "Feliz" -> 1
            "Bien" -> 2
            "Regular" -> 3
            "Estresado" -> 4
            "Triste" -> 5
            else -> 0
        }
    }
    fun sumarExp(exp:Double){
        session.sumarExp(exp)
        actualizarUsuario()
    }
    fun resetSubioNivel(){
        session.resetSubioNivel()
    }
}