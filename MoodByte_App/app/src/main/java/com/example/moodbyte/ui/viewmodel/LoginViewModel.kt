package com.example.moodbyte.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.moodbyte.data.local.AppDatabase
import com.example.moodbyte.data.local.daos.UsuarioDao
import com.example.moodbyte.data.local.entities.toDomain
import com.example.moodbyte.data.remote.ApiService
import com.example.moodbyte.data.repository.UsuarioRepository
import com.example.moodbyte.domain.model.Genero
import com.example.moodbyte.domain.model.TipoUsuario
import com.example.moodbyte.domain.model.Usuario
import com.example.moodbyte.domain.model.toEntity
import kotlinx.coroutines.launch
import java.time.LocalDate

class LoginViewModel(
    private val repo: UsuarioRepository,
    private val dao: UsuarioDao,
    private val session: UsuarioSesionViewModel
) : ViewModel() {

    sealed class LoginState {
        object Idle : LoginState()
        object Loading : LoginState()
        object Success : LoginState()
        object Error : LoginState()
    }

    private val _loginState = MutableLiveData<LoginState>(LoginState.Idle)
    val loginState: LiveData<LoginState> = _loginState
    private val _usuario = MutableLiveData<Usuario?>()
    val usuario: LiveData<Usuario?> = _usuario
    fun getLoginUsuario(nomUsu: String, password: String) {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            try {
                repo.refreshUsuarios()
                val usuarioRecibido = dao.login(nomUsu, password)
                if (usuarioRecibido != null) {
                    session.setusuario(usuarioRecibido.toDomain())
                    _loginState.value = LoginState.Success
                } else {
                    _loginState.value = LoginState.Error
                }
            } catch (e: Exception) {
                Log.e("LOGIN_ERROR", "Error en login", e)
                _loginState.value = LoginState.Error
            }
        }
    }

    fun crearUsuario(usuario: Usuario) {
        viewModelScope.launch {
            repo.insertarusuario(usuario)
        }
    }
}