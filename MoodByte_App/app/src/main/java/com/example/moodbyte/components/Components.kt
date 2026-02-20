package com.example.moodbyte.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moodbyte.ui.viewmodel.LoginViewModel
import com.example.moodbyte.ui.viewmodel.UsuarioViewModel
import com.example.moodbyte.domain.model.Usuario

//================ Contenido de la ventana home =================
@Composable
fun ContentHomeView(
    innerPadding: PaddingValues,
    navController: NavController,
    usuarioViewModel: UsuarioViewModel) {
    LazyColumn (
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color(0xFFD2E6F6)),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "MoodByte",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = Color.Black
            )
        }
    }
}

//================ Dialog de informacion =================
@Composable
fun DialogoInformativo(
    titulo: String,
    mensaje: String,
    onCerrar: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onCerrar,
        title = { Text(titulo) },
        text = { Text(mensaje) },
        confirmButton = {
            TextButton(onClick = onCerrar) {
                Text("Aceptar")
            }
        }
    )
}

//================ Contenido de la ventana Login =================
@Composable
fun ContentLoginView(
    innerPadding: PaddingValues,
    navController: NavController,
    loginViewModel: LoginViewModel
) {
    val usuario: Usuario? by loginViewModel.usuario.observeAsState()
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var loginAttempted by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(modifier = Modifier.padding(innerPadding)) {
            Column() {
                Text("Iniciar sesión")

                Spacer(modifier = Modifier.padding(10.dp))

                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Usuario") },
                    singleLine = true
                )

                Spacer(modifier = Modifier.padding(10.dp))

                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Contraseña") },
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.padding(4.dp))

                Button(onClick = {
                    loginViewModel.getLoginUsuario(email, password)
                    loginAttempted = true

                    //LaunchedEffect



                }) {
                    Text("Entrar")
                }
            }
        }

        LaunchedEffect(usuario) {
            if (loginAttempted) {
                if (usuario != null) {
                    navController.navigate("Home")
                } else {
                    showDialog = true
                }
            }
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Error al Iniciar sesión") },
                text = { Text("No se ha encontrado al usuario. Inténtalo otra vez") },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("OK")
                    }
                }
            )
        }

        Row(verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.End){
            Button(onClick = {
                loginViewModel.setUsuarioInvitado()
                navController.navigate("Home")
            }) {
                Text("Entrar como usuario invitado") }
        }



    }
}