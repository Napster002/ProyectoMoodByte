package com.example.moodbyte.components

import android.R
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ModeNight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.moodbyte.domain.model.Articulo
import com.example.moodbyte.domain.model.Genero
import com.example.moodbyte.domain.model.TipoUsuario
import com.example.moodbyte.ui.viewmodel.LoginViewModel
import com.example.moodbyte.domain.model.Usuario
import com.example.moodbyte.ui.viewmodel.ArticulosViewModel
import com.example.moodbyte.ui.viewmodel.HomeViewModel
import com.example.moodbyte.ui.viewmodel.PerfilViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.Period

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
    navController: NavController,
    loginViewModel: LoginViewModel
) {
    var nomUsu by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var crearUsuario by remember { mutableStateOf(false) }
    val loginState by loginViewModel.loginState.observeAsState(LoginViewModel.LoginState.Idle)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                "Registrarse",
                fontFamily = FontFamily(Font(com.example.moodbyte.R.font.fuentes)),
                modifier = Modifier.clickable {
                    crearUsuario = true
                }
            )
        }
        Image(
            painter = painterResource(R.drawable.ic_menu_view),
            contentDescription = "Logo MoodByte",
            modifier = Modifier.size(120.dp).padding(bottom = 24.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Iniciar sesión",
            color = Color(0xFFF5A15F),
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        TextField(
            value = nomUsu,
            onValueChange = { nomUsu = it },
            label = { Text("Usuario") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedLabelColor = Color(0xFFF56D5F),
                focusedIndicatorColor = Color(0xFFF56D5F)
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedLabelColor = Color(0xFFF56D5F),
                focusedIndicatorColor = Color(0xFFF56D5F)
            )
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                loginViewModel.getLoginUsuario(nomUsu, password)
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF56D5F),
                contentColor = Color(0xFF60F5D8)
            )
        ) {
            Text(
                "Entrar",
                fontWeight = FontWeight.Bold
            )
        }
    }
    Spacer(modifier = Modifier.height(40.dp))

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
    if (crearUsuario) {
        CrearUsuarioDialog(
            onDismiss ={ crearUsuario=false},
            onSave ={usuario->loginViewModel.crearUsuario(usuario)
            loginViewModel.getLoginUsuario(usuario.nombreUsuario,usuario.password)
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

@Composable
fun CrearUsuarioDialog(
    onDismiss: () -> Unit,
    onSave: (usuario:Usuario) -> Unit
){
    var nombreCompleto by remember{mutableStateOf("")}
    var nomUsu by remember{mutableStateOf("")}
    var password by remember{mutableStateOf("")}
    var edad by remember{mutableStateOf(0)}
    var genero by remember{mutableStateOf(Genero.OTRO)}
    val tipoUsuario= TipoUsuario.CLIENTE
    val fechaRegistro= LocalDate.now()
    var fechaNacimiento by remember{mutableStateOf("")}
    var fechaNacimientoConvert: LocalDate
    val nivel=0
    val expAcumulada=0.0

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                if(!nombreCompleto.equals("")&&!nomUsu.equals("")&&!password.equals("")&&!fechaNacimiento.equals("")){
                    try {
                        fechaNacimientoConvert =LocalDate.parse(fechaNacimiento)
                        edad= Period.between(fechaNacimientoConvert, LocalDate.now()).years
                        val usu=Usuario(
                            null,nombreCompleto,nomUsu,password,
                            edad,genero,tipoUsuario,fechaRegistro,fechaNacimientoConvert,nivel,expAcumulada
                        )
                        onSave(usu)
                        onDismiss()
                    }catch(e:Exception){
                        Log.i("EXCEPTION",e.toString())
                    }
                }
            }) {
                Text("Guardar Usuario",
                    color=Color(0xFFF56D5F)
                )
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar",
                    color=Color(0xFFF56D5F)
                )
            }
        },
        title = { Text("Nuevo Usuario",
            color = Color(0xFFF5A15F)) },
        text = {
            Column {
                OutlinedTextField(
                    value = nombreCompleto,
                    onValueChange = { nombreCompleto = it },
                    label = { Text("Nombre completo") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedLabelColor = Color(0xFFF56D5F),
                        focusedIndicatorColor = Color(0xFFF56D5F)
                    ),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(Modifier.height(12.dp))

                OutlinedTextField(
                    value = nomUsu,
                    onValueChange = { nomUsu = it },
                    label = { Text("Nombre de Usuario") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        focusedLabelColor = Color(0xFFF56D5F),
                        focusedIndicatorColor = Color(0xFFF56D5F)
                    ),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(Modifier.height(12.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Contaseña") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = TextFieldDefaults.colors(
                        focusedLabelColor = Color(0xFFF56D5F),
                        focusedIndicatorColor = Color(0xFFF56D5F)
                    )
                )
                Spacer(Modifier.height(12.dp))

                OutlinedTextField(
                    value = fechaNacimiento,
                    onValueChange = { fechaNacimiento = it },
                    label = { Text("Fecha de nacimiento (yyyy/MM/dd)") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = TextFieldDefaults.colors(
                        focusedLabelColor = Color(0xFFF56D5F),
                        focusedIndicatorColor = Color(0xFFF56D5F)
                    )
                )
                Spacer(Modifier.height(12.dp))

                    Text("Sexo")

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = genero==Genero.MASCULINO,
                            onClick = {  genero=Genero.MASCULINO},
                            colors= RadioButtonDefaults.colors(
                                selectedColor = Color(0xFFF5A15F)
                            )
                        )
                        Text("Masculino")
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = genero == Genero.FEMENINO,
                            onClick = { genero = Genero.FEMENINO },
                            colors= RadioButtonDefaults.colors(
                                selectedColor = Color(0xFFF5A15F)
                            )
                        )
                        Text("Femenino")
                    }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = genero == Genero.OTRO,
                        onClick = { genero = Genero.OTRO },
                        colors= RadioButtonDefaults.colors(
                            selectedColor = Color(0xFFF5A15F)
                        )
                    )
                    Text("Otro")
                }
                }
        },
        shape = RoundedCornerShape(20.dp)
    )
}





