package com.example.moodbyte.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ModeNight
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moodbyte.R
import com.example.moodbyte.components.BottomNavItem
import com.example.moodbyte.domain.model.Usuario
import com.example.moodbyte.ui.viewmodel.PerfilViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilView(navController: NavController,perfilViewModel: PerfilViewModel,onToggleTheme:()->Unit){
    val TitleFont= FontFamily(Font(R.font.hollyberrypop))
    var selectedIndex by remember { mutableStateOf(0) }
    val items = listOf(
        BottomNavItem("Home", R.drawable.home),
        BottomNavItem("Diario", R.drawable.agenda),
        BottomNavItem("Articulos", R.drawable.articulos),
        BottomNavItem("Ejercicios", R.drawable.ejercicios),
        BottomNavItem("Camara", R.drawable.cam),
        BottomNavItem("Perfil", R.drawable.user)
    )
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color(0xFFF56D5F),
                    titleContentColor = Color(0xFF60F5D8),
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                title = {
                    Text(
                        text = "MoodByte",
                        fontWeight = FontWeight.Bold,
                        fontFamily = TitleFont
                    )
                }
            )
        },
        bottomBar = {
            NavigationBar{
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = item.label)
                        },
                        label = { Text("") },
                        selected = selectedIndex == index,
                        onClick = { navController.navigate(item.label)}
                    )
                }
            }
        }
    ) { innerPadding ->
        PerfilViewContent(innerPadding,perfilViewModel,navController,onToggleTheme)
    }
}

//=================== Contenido del Perfil ============
@Composable
fun PerfilViewContent(
    paddingValues: PaddingValues,
    perfilViewModel: PerfilViewModel,
    navController: NavController,
    onToggleTheme: () -> Unit
){
    val usuario=perfilViewModel.usuario.observeAsState()
    val scope = rememberCoroutineScope()
    var mostrarDialogo by remember { mutableStateOf(false) }
    LazyColumn(
        modifier=Modifier.padding(paddingValues)
            .fillMaxSize()
            .padding(16.dp)
    ){
        item{
            DatosPerfil(usuario)
        }
        item{
            EditarPerfilSection {
                mostrarDialogo=true
            }
        }
        item{
            CambiarModoVisual(onToggleTheme)
        }
        item{
            CerrarSesion(onEdit = {
                navController.navigate("Login"){
                    popUpTo(0){inclusive=true}
                    perfilViewModel.cerrarSesion();
                }
            }
            )
        }
    }
    if (mostrarDialogo){
        EditarPerfilDialog( usuario = usuario,
            onDismiss = {
                mostrarDialogo = false },
            onSave = { nuevoNombre, nuevoNomUsu, password ->
                scope.launch {
                    perfilViewModel.actualizarUsuario(nuevoNombre, nuevoNomUsu, password)
                }; mostrarDialogo = false })
    }
}

@Composable
fun DatosPerfil(usuario: State<Usuario?>){
    if(usuario!=null) {
        val genero1 = usuario.value?.genero.toString().substring(0, 1)
        val genero2 = usuario.value?.genero.toString().substring(1).lowercase()
        val generoUsu = genero1 + genero2

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(12.dp))
            Text(
                text = usuario.value?.nombreCompleto?:"",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Usuario: " + usuario.value?.nombreUsuario,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Genero: " + generoUsu,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Nivel: " + usuario.value?.nivel?.toString() + " Exp: " + usuario.value?.expAcumulada?.toString(),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }
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
    usuario: State<Usuario?>,
    onDismiss: () -> Unit,
    onSave: (String, String, String) -> Unit
) {
    var nombre by remember { mutableStateOf(usuario.value?.nombreCompleto) }
    var nomUsu by remember { mutableStateOf(usuario.value?.nombreUsuario) }
    var password by remember {mutableStateOf(usuario.value?.password)}

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = { onSave(nombre!!, nomUsu!!,password!!) }) {
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
                    value = nombre!!,
                    onValueChange = { nombre = it },
                    label = { Text("Nombre de usuario") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(Modifier.height(12.dp))

                OutlinedTextField(
                    value = nomUsu!!,
                    onValueChange = { nomUsu = it },
                    label = { Text("Nombre de Usuario") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(Modifier.height(12.dp))

                OutlinedTextField(
                    value = password!!,
                    onValueChange = { password = it },
                    label = { Text("Contaseña") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )
            }
        },
        shape = RoundedCornerShape(20.dp)
    )
}

@Composable
fun CerrarSesion(onEdit:()-> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        ListItem(
            headlineContent = { Text("Cerrar Sesión") },
            supportingContent = { Text("Termina la sesión activa y vuelve al login") },
            leadingContent = {
                Icon(Icons.Default.Close, contentDescription = null)
            },
            trailingContent = {
                Icon(Icons.Default.ArrowForward, contentDescription = null)
            },
            modifier = Modifier.clickable {
                onEdit()
            }
        )
    }
}

@Composable
fun CambiarModoVisual(onEdit:()->Unit){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        ListItem(
            headlineContent = { Text("Cambiar Tema") },
            supportingContent = { Text("Alternar entre modo claro y modo oscuro") },
            leadingContent = {
                Icon(Icons.Default.ModeNight, contentDescription = null)
            },
            trailingContent = {
                Icon(Icons.Default.ArrowForward, contentDescription = null)
            },
            modifier = Modifier.clickable {
                onEdit()
            }
        )
    }
}
