package com.example.moodbyte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.moodbyte.data.local.AppDatabase
import com.example.moodbyte.data.remote.RetrofitClient
import com.example.moodbyte.data.repository.UsuarioRepository
import com.example.moodbyte.navigation.NavManager
import com.example.moodbyte.ui.screens.MainScreen
import com.example.moodbyte.ui.viewmodel.UsuarioViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
// Cambiar por navManager, quitar genericaView y meter todo en HomeView en caso de volver atras
        setContent {
            val usuarioViewModel: UsuarioViewModel = koinViewModel()
            MainScreen(usuarioViewModel)
        }
    }
}