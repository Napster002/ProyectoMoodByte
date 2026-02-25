package com.example.moodbyte.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moodbyte.data.remote.dtos.DiarioDto
import com.example.moodbyte.domain.model.Usuario
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class UsuarioSesionViewModel : ViewModel(){
    //Usuario que se guarda al loggearse
    private val _usuario = MutableStateFlow<Usuario?>(null)
    val usuario= _usuario.asStateFlow()
    //Mood que se guarda al responder a la encuesta de emojis y boolean que muestra si ya ha respondido
    private val _mood = MutableStateFlow<Int>(0)
    val mood= _mood.asStateFlow()
    private val _registroDiario=MutableStateFlow<Boolean>(false)
    val registroDiario=_registroDiario.asStateFlow()

    private val _subioNivel = MutableStateFlow(false)
    val subioNivel = _subioNivel.asStateFlow()

    private val _diario = MutableStateFlow<DiarioDto?>(null)
    val diario = _diario.asStateFlow()

    fun setusuario(usuario:Usuario?){
        _usuario.value=usuario
    }
    fun setMood(mood:Int){
        _mood.value=mood
    }
    fun checkRegistroDiario(check: Boolean){
        _registroDiario.value=check
    }

    fun sumarExp(cantidad: Double){
        val usuarioActual = _usuario.value ?: return
        var nuevaExp = usuarioActual.expAcumulada + cantidad
        var nuevoNivel = usuarioActual.nivel

        val expNecesaria = 100 * usuarioActual.nivel
        if (nuevaExp >= expNecesaria) {
            nuevaExp -= expNecesaria
            nuevoNivel++
            _subioNivel.value=true
        }
        val usuarioActualizado = usuarioActual.copy(
            nivel = nuevoNivel,
            expAcumulada = nuevaExp
        )
        _usuario.value = usuarioActualizado

    }
    fun resetSubioNivel(){
        _subioNivel.value=false
    }
    fun setDiario(d: DiarioDto) {
        _diario.value = d
    }
}