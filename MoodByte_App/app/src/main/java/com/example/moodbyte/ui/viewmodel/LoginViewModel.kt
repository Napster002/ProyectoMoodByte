package com.example.moodbyte.ui.viewmodel

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
import com.example.moodbyte.domain.model.Usuario
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repo: UsuarioRepository,
    private val dao: UsuarioDao,
    private val session: UsuarioSesionViewModel
) : ViewModel() {
    private val _usuario = MutableLiveData<Usuario?>()
    val usuario: LiveData<Usuario?> = _usuario

    fun getLoginUsuario(nomUsu:String,password:String){
        viewModelScope.launch {
            repo.refreshUsuarios()
            try{
                val usuarioRecibido=dao.login(nomUsu,password)
                if(usuarioRecibido!=null){
                    session.setusuario(usuarioRecibido.toDomain())
                }
                _usuario.value= usuarioRecibido?.toDomain()
            }catch(e:Exception){
                _usuario.value=null
            }
        }
    }
}