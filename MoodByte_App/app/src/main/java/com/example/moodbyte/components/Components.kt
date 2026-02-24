package com.example.moodbyte.components

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.provider.MediaStore
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.moodbyte.components.chatbotcomponents.ChatBot
import com.example.moodbyte.components.chatbotcomponents.DetectorCara
import com.example.moodbyte.components.chatbotcomponents.DetectorEmociones
import com.example.moodbyte.components.chatbotcomponents.Mensaje
import com.example.moodbyte.components.chatbotcomponents.obtenerSaludo
import com.example.moodbyte.domain.model.Articulo

import com.example.moodbyte.domain.model.Entrada
import com.example.moodbyte.ui.viewmodel.LoginViewModel
import com.example.moodbyte.domain.model.Usuario
import com.example.moodbyte.ui.viewmodel.ArticulosViewModel
import com.example.moodbyte.ui.viewmodel.DiarioViewModel
import com.example.moodbyte.domain.model.Ejercicio
import com.example.moodbyte.ui.viewmodel.EjercicioViewModel
import com.example.moodbyte.ui.viewmodel.EmocionViewModel
import com.example.moodbyte.ui.viewmodel.HomeViewModel
import com.example.moodbyte.ui.viewmodel.PerfilViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate
import java.util.Calendar

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
fun ArticulosViewContent(paddingValues: PaddingValues, articulosViewModel: ArticulosViewModel) {
    val articulos = articulosViewModel.articulos.collectAsState()
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        items(articulos.value) { articulo ->
            ArticuloCard(articulo) { url ->
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
    val scope = rememberCoroutineScope()
    var mostrarDialogo by remember { mutableStateOf(false) }
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            DatosPerfil(usuario!!)
        }
        item {
            EditarPerfilSection {
                mostrarDialogo = true
            }
        }
    }
    if (mostrarDialogo) {
        EditarPerfilDialog(
            usuario = usuario!!,
            onDismiss = {
                mostrarDialogo = false },
            onSave = { nuevoNombre, nuevoNomUsu,password ->
                scope.launch {
                    perfilViewModel.actualizarUsuario(nuevoNombre, nuevoNomUsu, password)
                }; mostrarDialogo = false })
    }
}

@Composable
fun DatosPerfil(usuario:Usuario){
    var genero1=usuario.genero.toString().substring(0,1)
    var genero2=usuario.genero.toString().substring(1).lowercase()
    val generoUsu=genero1+genero2

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
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Usuario: "+usuario.nombreUsuario,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Genero: "+generoUsu,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Nivel: "+usuario.nivel.toString()+" Exp: "+usuario.expAcumulada.toString(),
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
    onSave: (String, String,String) -> Unit
) {
    var nombre by remember { mutableStateOf(usuario.nombreCompleto) }
    var nomUsu by remember { mutableStateOf(usuario.nombreUsuario) }
    var password by remember {mutableStateOf(usuario.password)}

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = { onSave(nombre, nomUsu,password) }) {
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

                Spacer(Modifier.height(12.dp))

                OutlinedTextField(
                    value = password,
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
//=================== Contenido del IA ============
@Composable
fun IAViewContent(paddingValues: PaddingValues){
    val context = LocalContext.current
    val detector = remember { DetectorEmociones(context) }
    val detectorCara = remember { DetectorCara(context) } // Detector de cara real
    val chatBot = remember { ChatBot() }

    var bitmap by remember { mutableStateOf<Bitmap?>(null) }
    var emocionActual by remember { mutableStateOf("Neutral") }
    var caraDetectada by remember { mutableStateOf(false) }
    var primerMensajeMostrado by remember { mutableStateOf(false) } // <-- NUEVO

    var pregunta by remember { mutableStateOf("") }

    val chats = remember { mutableStateListOf<Mensaje>() }

    val scope = rememberCoroutineScope()

    // SELECTOR IMAGEN
    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->

        uri ?: return@rememberLauncherForActivityResult

        scope.launch(Dispatchers.IO) {

            try {

                val bmp = MediaStore.Images.Media.getBitmap(
                    context.contentResolver,
                    uri
                )

                val scaled = Bitmap.createScaledBitmap(
                    bmp,
                    64,
                    64,
                    true
                )

                val hayCara = detectorCara.hayCara(bmp) // Detecta si hay cara real
                val emocion = if (hayCara) detector.detectar(scaled) else "Neutral"

                withContext(Dispatchers.Main) {

                    bitmap = bmp // Actualizar imagen
                    chats.clear() // Reiniciar chat al cambiar imagen
                    caraDetectada = false // Bloquea chat por defecto
                    primerMensajeMostrado = false // Reinicia flag si se cambia imagen

                    if (hayCara) {

                        caraDetectada = true
                        emocionActual = emocion

                        // MENSAJE AUTOMÁTICO SOLO EN LA PRIMERA FOTO
                        if (!primerMensajeMostrado) {
                            val saludo = obtenerSaludo()
                            val respuesta = chatBot.responder("", emocion)

                            chats.add(
                                Mensaje(
                                    texto = "$saludo 😊",
                                    esUsuario = false
                                )
                            )

                            primerMensajeMostrado = true
                        }

                    } else {

                        emocionActual = "Neutral"

                        chats.add(
                            Mensaje(
                                texto = "No se detectó ninguna cara.\nSube una imagen válida para activar el chat.",
                                esUsuario = false
                            )
                        )
                    }
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(9.dp)
            .imePadding()
            .navigationBarsPadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { launcher.launch("image/*") }
        ) {
            Text("Seleccionar imagen")
        }

        Spacer(modifier = Modifier.height(16.dp))

        bitmap?.let {

            Image(
                bitmap = it.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(
                        Color.LightGray,
                        RoundedCornerShape(8.dp)
                    )
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text("Emoción: $emocionActual")

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {

            items(chats) { chat ->

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    horizontalArrangement =
                        if (chat.esUsuario)
                            Arrangement.Start
                        else
                            Arrangement.End
                ) {

                    Box(
                        modifier = Modifier
                            .background(
                                if (chat.esUsuario) Color(0xFF2196F3) else Color.LightGray,
                                RoundedCornerShape(8.dp)
                            )
                            .clickable(enabled = chat.url != null) {
                                chat.url?.let {
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
                                    context.startActivity(intent)
                                }
                            }
                            .padding(10.dp)
                    ) {

                        Text(
                            chat.texto,
                            color = if (chat.esUsuario) Color.White else Color.Black
                        )
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        // CAMPO BLOQUEADO SI NO HAY CARA
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically

        ) {
            OutlinedTextField(
                value = pregunta,
                onValueChange = { pregunta = it },
                label = { Text("Pregunta") },
                modifier = Modifier
                    .weight(0.8f), // ocupa 80% del espacio disponible
                enabled = caraDetectada,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Send // Cambia el botón Enter a "Send"
                ),
                keyboardActions = KeyboardActions(
                    onSend = {
                        // Se ejecuta cuando se pulsa Enter/Send
                        if (pregunta.isNotBlank()) {
                            chats.add(Mensaje(texto = pregunta, esUsuario = true))
                            val respuesta = chatBot.responder(pregunta, emocionActual)
                            chats.add(
                                Mensaje(
                                    texto = respuesta.texto,
                                    url = respuesta.url,
                                    esUsuario = false
                                )
                            )
                            pregunta = ""
                        }
                    }
                )
            )
            Spacer(modifier = Modifier.width(8.dp)) // separación

            Button(
                onClick = {
                    if (pregunta.isNotBlank()) {
                        chats.add(Mensaje(texto = pregunta, esUsuario = true))
                        val respuesta = chatBot.responder(pregunta, emocionActual)
                        chats.add(
                            Mensaje(
                                texto = respuesta.texto,
                                url = respuesta.url,
                                esUsuario = false
                            )
                        )
                        pregunta = ""
                    }
                },
                enabled = caraDetectada
            ) {
                Text("->")
            }
        }
    }
}

//================ Contenido de la ventana diario =================
@Composable
fun ContentDiarioView(
    innerPadding: PaddingValues,
    navController: NavController,
    diarioViewModel: DiarioViewModel
) {
    val entradas by diarioViewModel.entradas.collectAsState()

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color(0xFFD2E6F6)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Tu Diario",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            modifier = Modifier.padding(16.dp)
        )

        DiarioCalendarView(
            entradas = diarioViewModel.entradas.collectAsState().value,
            onDaySelected = { date ->
                val entrada = diarioViewModel.getEntradaFor(date)
                if (entrada != null) {
                    navController.navigate("diarioDetalle/$date")
                } else {
                    navController.navigate("diarioEditar/$date")
                }
            }
        )
    }

}
@Composable
fun DiarioCalendarView(
    entradas: List<Entrada>,
    onDaySelected: (LocalDate) -> Unit
) {
    AndroidView(
        factory = { context ->
            CalendarView(context).apply {
                val fechasConEntrada = entradas.map { it.fechaEntrada }.toSet()

                setOnDateChangeListener { _, year, month, day ->
                    val fecha = LocalDate.of(year, month + 1, day)

                    if (fecha in fechasConEntrada) {
                        onDaySelected(fecha)
                    }
                }

            }
        }
    )
}
//=============Contenido de la ventana Ejercicios=================
@Composable
fun EjercicioViewContent(
    paddingValues: PaddingValues,
    ejercicioViewModel: EjercicioViewModel,
    emocionViewModel: EmocionViewModel
) {
    val ejercicios = ejercicioViewModel.ejercicios.collectAsState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        items(ejercicios.value) { ejercicio ->
            EjercicioCard(ejercicio)
        }
    }
}
//=========Composable para mostrar los ejercicios========
@Composable
fun EjercicioCard(
    ejercicio: Ejercicio
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column {
            AsyncImage(
                model = ejercicio.recursoUrl,
                contentDescription = ejercicio.titulo,
                modifier = Modifier
                    .fillMaxWidth().height(180.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = ejercicio.titulo,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 12.dp)
            )
            Text(text = ejercicio.descripcion,
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}
