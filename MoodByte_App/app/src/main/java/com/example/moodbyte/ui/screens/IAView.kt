package com.example.moodbyte.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.moodbyte.R
//import com.example.moodbyte.components.ArticulosViewContent
import com.example.moodbyte.components.BottomNavItem
import com.example.moodbyte.components.IAViewContent

/*
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moodbyte.components.chatbotcomponents.DetectorCara
import com.example.moodbyte.components.chatbotcomponents.DetectorEmociones
import com.example.moodbyte.components.chatbotcomponents.Mensaje
import com.example.moodbyte.components.chatbotcomponents.ChatBot
import com.example.moodbyte.components.chatbotcomponents.obtenerSaludo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IAView(navController:NavController){
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
        IAViewContent(innerPadding)
    }
}
/*
@Composable
fun IAView() {

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
            .padding(16.dp)
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
*/