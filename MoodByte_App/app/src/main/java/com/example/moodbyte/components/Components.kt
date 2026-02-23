package com.example.moodbyte.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.moodbyte.domain.model.Articulo
import com.example.moodbyte.ui.viewmodel.LoginViewModel
import com.example.moodbyte.domain.model.Usuario
import com.example.moodbyte.ui.viewmodel.ArticulosViewModel
import com.example.moodbyte.ui.viewmodel.HomeViewModel
import com.example.moodbyte.ui.viewmodel.PerfilViewModel
import com.example.moodbyte.ui.viewmodel.UsuarioSesionViewModel

//================ Contenido de la ventana home =================
@Composable
fun ContentHomeView(
    innerPadding: PaddingValues,
    navController: NavController,
    homeViewModel: HomeViewModel) {
    var showMoodDialog by remember { mutableStateOf(true) }
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
        item {
            if (showMoodDialog) {
                AlertDialog(
                    onDismissRequest = { showMoodDialog = false },
                    title = { Text("¿Cómo te sientes hoy?") },
                    text = {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Elige tu estado de ánimo")

                            Spacer(Modifier.height(16.dp))

                            Row(
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                MoodButton("😄", "Feliz") { mood ->
                                    homeViewModel.setMood(mood)
                                    showMoodDialog = false
                                }
                                MoodButton("🙂", "Bien") { mood ->
                                    homeViewModel.setMood(mood)
                                    showMoodDialog = false
                                }
                                MoodButton("😐", "Regular") { mood ->
                                    homeViewModel.setMood(mood)
                                    showMoodDialog = false
                                }
                                MoodButton("\uD83D\uDE30","Estresado"){ mood->
                                    homeViewModel.setMood(mood)
                                    showMoodDialog=false
                                }
                                MoodButton("😔", "Triste") { mood ->
                                    homeViewModel.setMood(mood)
                                    showMoodDialog = false
                                }
                            }
                        }
                    },
                    confirmButton = {}
                )
            }
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
    var nomUsu by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    val loginState by loginViewModel.loginState.observeAsState(LoginViewModel.LoginState.Idle)


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
                    value = nomUsu,
                    onValueChange = { nomUsu = it },
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
                    loginViewModel.getLoginUsuario(nomUsu, password)
                }) {
                    Text("Entrar")
                }
            }
            }

        LaunchedEffect(loginState) {
            when (loginState) {
                LoginViewModel.LoginState.Success -> {
                    navController.navigate("Inicio")
                }
                LoginViewModel.LoginState.Error -> {
                    showDialog = true
                }
                else -> Unit
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
    }
//==========Boton selector de Estado emocional===========
@Composable
fun MoodButton(emoji: String, label: String, onClick: (String) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable { onClick(label) }
            .padding(8.dp)
    ) {
        Text(text = emoji, fontSize = 40.sp)
        Text(text = label)
    }
}

//=============Contenido de la ventana Articulos=================
@Composable
fun ArticulosViewContent(paddingValues: PaddingValues,articulosViewModel: ArticulosViewModel){
    val articulos=articulosViewModel.articulos.collectAsState()
    val context = LocalContext.current
    LazyColumn(
        modifier=Modifier.fillMaxSize()
            .padding(paddingValues)
    ) {
        items(articulos.value){
            articulo-> ArticuloCard(articulo){
                url ->
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        }
        }
    }
}


//=========Composable para mostrar los articulos========
@Composable
fun ArticuloCard(
    articulo: Articulo,
    onClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable { onClick(articulo.enlace) },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column {
            AsyncImage(
                model = articulo.imagen,
                contentDescription = articulo.titulo,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = articulo.titulo,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 12.dp)
            )

            Text(
                text = articulo.subtitulo,
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}

//=================== Contenido del Perfil ============
@Composable
fun PerfilViewContent(paddingValues: PaddingValues, perfilViewModel: PerfilViewModel){
    val usuario=perfilViewModel.usuario
    var mostrarDialogo by remember { mutableStateOf(false) }
    LazyColumn(
        modifier=Modifier.padding(paddingValues)
            .fillMaxSize()
            .padding(16.dp)
    ){
        item{
            DatosPerfil(usuario!!)
        }
        item{
            EditarPerfilSection {
                mostrarDialogo=true
            }
        }
    }
    if (mostrarDialogo){
        EditarPerfilDialog( usuario = usuario!!,
            onDismiss = {
                mostrarDialogo = false },
            onSave = { nuevoNombre, nuevoNomUsu -> perfilViewModel.actualizarUsuario(nuevoNombre, nuevoNomUsu); mostrarDialogo = false })
    }
}

@Composable
fun DatosPerfil(usuario:Usuario){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(Modifier.height(12.dp))

            Text(
                text = usuario.nombreCompleto,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = usuario.nombreUsuario,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }
    }

@Composable
fun EditarPerfilSection(onEdit: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        ListItem(
            headlineContent = { Text("Editar perfil") },
            supportingContent = { Text("Cambia tu nombre, nombre de usuario o contraseña") },
            leadingContent = {
                Icon(Icons.Default.Edit, contentDescription = null)
            },
            trailingContent = {
                Icon(Icons.Default.ArrowForward, contentDescription = null)
            },
            modifier = Modifier.clickable { onEdit() }
        )
    }
}

@Composable
fun EditarPerfilDialog(
    usuario: Usuario,
    onDismiss: () -> Unit,
    onSave: (String, String) -> Unit
) {
    var nombre by remember { mutableStateOf(usuario.nombreCompleto) }
    var nomUsu by remember { mutableStateOf(usuario.nombreUsuario) }

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = { onSave(nombre, nomUsu) }) {
                Text("Guardar")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        },
        title = { Text("Editar perfil") },
        text = {
            Column {

                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Nombre de usuario") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(Modifier.height(12.dp))

                OutlinedTextField(
                    value = nomUsu,
                    onValueChange = { nomUsu = it },
                    label = { Text("Nombre de Usuario") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )
            }
        },
        shape = RoundedCornerShape(20.dp)
    )
}





