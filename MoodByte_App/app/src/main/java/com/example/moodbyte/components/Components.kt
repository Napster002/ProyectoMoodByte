package com.example.moodbyte.components

import android.R
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.icons.filled.ModeNight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.moodbyte.components.chatbotcomponents.ChatBot
import com.example.moodbyte.components.chatbotcomponents.DetectorCara
import com.example.moodbyte.components.chatbotcomponents.DetectorEmociones
import com.example.moodbyte.components.chatbotcomponents.Mensaje
import com.example.moodbyte.components.chatbotcomponents.obtenerSaludo
import com.example.moodbyte.domain.model.Articulo
import com.example.moodbyte.domain.model.Genero
import com.example.moodbyte.domain.model.TipoUsuario

import com.example.moodbyte.domain.model.Entrada
import com.example.moodbyte.ui.viewmodel.LoginViewModel
import com.example.moodbyte.domain.model.Usuario
import com.example.moodbyte.ui.viewmodel.ArticulosViewModel
import com.example.moodbyte.ui.viewmodel.DiarioViewModel
import com.example.moodbyte.domain.model.Ejercicio
import com.example.moodbyte.domain.model.Estado
import com.example.moodbyte.ui.viewmodel.EjercicioViewModel
import com.example.moodbyte.ui.viewmodel.EstadoViewModel
import com.example.moodbyte.ui.viewmodel.HomeViewModel
import com.example.moodbyte.ui.viewmodel.PerfilViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate
import com.example.moodbyte.R
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
import java.time.LocalDate
import java.time.Period

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
            onClick = { launcher.launch("image/*") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFC908B), // Rosita
                contentColor = Color.White           // Letras blancas
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
        ) {
            Text("Seleccionar imagen",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp)
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

        Text("Emoción: $emocionActual",
            color = Color(0xFFFC908B))

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
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFFC908B),
                    unfocusedBorderColor = Color(0xFFFC908B),
                    focusedLabelColor = Color(0xFFFC908B),
                    unfocusedLabelColor = Color(0xFFFC908B),
                    cursorColor = Color(0xFFFC908B)
                ),
                shape = RoundedCornerShape(12.dp),
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
                enabled = caraDetectada,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFC908B),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.height(50.dp)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjercicioViewContent(
    paddingValues: PaddingValues,
    ejercicioViewModel: EjercicioViewModel,
    emocionViewModel: EstadoViewModel
) {
        val estados by emocionViewModel.estados.collectAsState()
        var expanded by remember { mutableStateOf(false) }
        var selectedOption by remember{mutableStateOf("Todos")}
        val ejercicios by ejercicioViewModel.ejercicios.collectAsState()
    Column(modifier=Modifier.fillMaxSize().padding(paddingValues)
        .padding(16.dp)
    ) {
        Row(modifier= Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically) {
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },
                modifier = Modifier.weight(0.7f),

            ) {
                OutlinedTextField(
                    value = selectedOption,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Estados") },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                    },
                    modifier = Modifier.menuAnchor().fillMaxWidth()
                , colors= OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFFC908B),
                    unfocusedBorderColor = Color(0xFFFC908B),
                    focusedLabelColor = Color(0xFFFC908B),
                    unfocusedLabelColor = Color(0xFFFC908B),
                    cursorColor = Color(0xFFFC908B)
                )
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }) {
                    estados.forEach { estados ->
                        DropdownMenuItem(
                            text = { Text(estados.nombre,color =Color(0xFFFC908B) ) },
                            onClick = {
                                selectedOption = estados.nombre
                                expanded = false
                                ejercicioViewModel.cargarEjerciciosPorEstado(estados.nombre)
                            },
                            colors= MenuDefaults.itemColors(
                                textColor=Color(0xFFFC908B)
                            )
                        )
                    }
                }
            }

            EjercicioCustomRoundedButton("Reset",Color(0xFFFC908B),modifier=Modifier.weight(0.3f),onClick = {
                selectedOption = "Todos"
                ejercicioViewModel.recargarEjercicios()
            })
        }
        Spacer(modifier=Modifier.height(5.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items(ejercicios) { ejercicio ->
                EjercicioCard(ejercicio)
            }
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
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardColors(Color(0xFFD2E6F6),Color(0xFFD2E6F6),Color(0xFFD2E6F6),Color(0xFFD2E6F6))
    ) {
        Column (verticalArrangement = Arrangement.spacedBy(5.dp),
            ){
            var imageLoadFailed by remember {mutableStateOf(false)}
            if(!imageLoadFailed){
                AsyncImage(
                    model = ejercicio.recursoUrl,
                    contentDescription = ejercicio.titulo,
                    modifier = Modifier
                        .fillMaxWidth().height(180.dp),
                    contentScale = ContentScale.Crop,
                    onError ={imageLoadFailed=true}
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = ejercicio.titulo,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 12.dp)
                , color = Color(0xFF60F5D8)
            )
            Text(text = ejercicio.descripcion,
                fontSize = 14.sp,
                color = Color.Blue,
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CrearEjercicioDialog(
    onDismiss: () -> Unit,
    onGuardar: (titulo: String, descripcion: String, recursoUrl: String, duracion: String, estadoId: Long) -> Unit,
    estadoViewModel: EstadoViewModel
) {
    val estados by estadoViewModel.estados.collectAsState()
    var titulo by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var recursoUrl by remember { mutableStateOf("") }
    var duracion by remember { mutableStateOf("") }
    var estadoSeleccionado by remember { mutableStateOf<Estado?>(null) }
    var expanded by remember { mutableStateOf(false) }

    Dialog(onDismissRequest = onDismiss) {
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    "Crear Ejercicio",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color(0xFFFC908B)
                )

                OutlinedTextField(
                    value = titulo,
                    onValueChange = { titulo = it },
                    label = { Text("Título") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = descripcion,
                    onValueChange = { descripcion = it },
                    label = { Text("Descripción") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = recursoUrl,
                    onValueChange = { recursoUrl = it },
                    label = { Text("URL Recurso") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = duracion,
                    onValueChange = { duracion = it },
                    label = { Text("Duración (HH:MM:SS)") },
                    modifier = Modifier.fillMaxWidth()
                )

                // Dropdown para seleccionar estado
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedTextField(
                        value = estadoSeleccionado?.nombre ?: "Selecciona estado",
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Estado") },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
                        modifier = Modifier.menuAnchor().fillMaxWidth()
                    )
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        estados.forEach { estado ->
                            DropdownMenuItem(
                                text = { Text(estado.nombre, color = Color(0xFFFC908B)) },
                                onClick = {
                                    estadoSeleccionado = estado
                                    expanded = false
                                },
                                colors = MenuDefaults.itemColors(
                                    textColor = Color(0xFFFC908B)
                                )
                            )
                        }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Cancelar", color = Color.Gray)
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(
                        onClick = {
                            if (titulo.isNotBlank() && descripcion.isNotBlank() && estadoSeleccionado != null) {
                                onGuardar(
                                    titulo,
                                    descripcion,
                                    recursoUrl,
                                    duracion,
                                    estadoSeleccionado!!.id
                                )
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFC908B),
                            contentColor = Color.White
                        )
                    ) {
                        Text("Guardar")
                    }
                }
            }
        }
    }
}