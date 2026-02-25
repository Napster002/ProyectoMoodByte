package com.example.moodbyte.ui.screens

import android.R
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.moodbyte.domain.model.Genero
import com.example.moodbyte.domain.model.TipoUsuario
import com.example.moodbyte.domain.model.Usuario
import com.example.moodbyte.ui.viewmodel.LoginViewModel
import java.time.LocalDate
import java.time.Period

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView(navController: NavController, loginViewModel: LoginViewModel){
   ContentLoginView(navController, loginViewModel)
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
            navController.navigate("Home")
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
         onSave ={ usuario->loginViewModel.crearUsuario(usuario)
            loginViewModel.getLoginUsuario(usuario.nombreUsuario,usuario.password)
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
                     id=null, nombreCompleto = nombreCompleto, nombreUsuario = nomUsu, password = password,
                     edad=edad,genero=genero, tipoUsuario = tipoUsuario,fechaRegistro=fechaRegistro, fechaNacimiento = fechaNacimientoConvert,
                     nivel=nivel, expAcumulada=expAcumulada
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