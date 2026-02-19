package com.example.moodbyte.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moodbyte.ui.viewmodel.UsuarioViewModel

@Composable
fun UsuarioView(navController: NavController, viewModel: UsuarioViewModel) {

    val usuarios by viewModel.usuarios.observeAsState(emptyList())

    Column(modifier = Modifier.padding(16.dp)) {

        Button(onClick = { viewModel.refrescar() }) {
            Text("Actualizar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(usuarios) { usuario ->
                Column(modifier = Modifier.padding(8.dp)) {
                    Text("Nombre: ${usuario.nombreCompleto}")
                    Text("Usuario: ${usuario.nombreUsuario}")
                    Text("Nivel: ${usuario.nivel}")
                    Text("Exp: ${usuario.expAcumulada}")
                }
            }
        }
    }
}