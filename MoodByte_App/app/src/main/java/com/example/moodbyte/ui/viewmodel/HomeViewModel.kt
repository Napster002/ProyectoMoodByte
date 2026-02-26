package com.example.moodbyte.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moodbyte.data.local.entities.toDomain
import com.example.moodbyte.data.remote.ApiService
import com.example.moodbyte.data.remote.dtos.toEntity
import com.example.moodbyte.data.repository.FraseRepository
import com.example.moodbyte.data.repository.RegistroRepository
import com.example.moodbyte.data.repository.UsuarioRepository
import com.example.moodbyte.domain.model.Frase
import com.example.moodbyte.domain.model.Registro
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import java.time.LocalDate
import kotlin.random.Random

class HomeViewModel(
    private val session: UsuarioSesionViewModel,
    private val repo: RegistroRepository,
    private val usuRepo: UsuarioRepository,
    private val frasesApi: ApiService
) : ViewModel() {
    val usuario = session.usuario
    val subioNivel = session.subioNivel
    val registroDiario=session.registroDiario

    //Para cargar la frase del Mood
    private val _fraseMood = MutableStateFlow<String?>(null)
    val fraseMood = _fraseMood.asStateFlow()
    private var frasesRecibidas: List<Frase> = emptyList()
    //Para el grafico semanal
    private val _semanaMoods = MutableStateFlow<List<Int>>(emptyList())
    val semanaMoods = _semanaMoods.asStateFlow()




    //Lista de registros que cargaremos
    init {
        viewModelScope.launch {
            session.usuario.collect { user ->
                if (user?.id != null) {
                    cargarFrases()
                    cargarSemanaMoods()
                    comprobarRegistros()
                }
            }
        }
        viewModelScope.launch {
            session.mood.collect {
                actualizarFraseMood()
                cargarSemanaMoods()
            }
        }
    }

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

    fun comprobarRegistros(){
        session.comprobarRegistro()
    }
    fun cerrarDialogRegistro(){
        session.cerrarDialogRegistro()
    }

    //Metodo para devolver una frase aleatoria en funcion del mood del día
    fun actualizarFraseMood(){
        val mood=session.mood.value?:return
        val frasesFiltradas=frasesRecibidas.filter { it.puntuacion==mood }
        _fraseMood.value=frasesFiltradas.randomOrNull()?.frase
    }
    fun cargarFrases(){
        viewModelScope.launch {
            val frases = frasesApi.getFrases()
            frasesRecibidas = frases.map { it.toEntity().toDomain() }
            actualizarFraseMood()
        }
    }
    fun cargarSemanaMoods() {
        viewModelScope.launch {
            val registros = session.getRegistrosSemana()

            // Creamos un mapa fecha → mood
            val mapa = registros.associate {
                LocalDate.parse(it.fechaRegistro) to it.puntuacion
            }

            val hoy = LocalDate.now()
            val lista = (0..6).map { diasAtras ->
                val fecha = hoy.minusDays(diasAtras.toLong())
                mapa[fecha] ?: 0 // 0 = sin registro
            }.reversed()
            _semanaMoods.value = lista
            Log.i("SEMANA", _semanaMoods.toString())
        }
    }

}