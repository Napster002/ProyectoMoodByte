package com.example.moodbyte.components

import android.R
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import android.provider.MediaStore
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
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ModeNight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import com.example.moodbyte.ui.viewmodel.LoginViewModel
import com.example.moodbyte.domain.model.Usuario
import com.example.moodbyte.ui.viewmodel.ArticulosViewModel
import com.example.moodbyte.ui.viewmodel.HomeViewModel
import com.example.moodbyte.ui.viewmodel.PerfilViewModel
import com.example.moodbyte.ui.viewmodel.UsuarioSesionViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.Period


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