package com.example.moodbyte.ui.screens

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.moodbyte.components.BottomNavItem
import com.example.moodbyte.components.DialogoInformativo
import kotlinx.coroutines.launch
import com.example.moodbyte.R
import com.example.moodbyte.ui.viewmodel.HomeViewModel
import com.example.moodbyte.ui.viewmodel.LoginViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.moodbyte.R


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navController: NavController, homeViewModel: HomeViewModel){
    var mostrarDialogo by remember { mutableStateOf(false) }
    val usuarioState=homeViewModel.usuario.collectAsState()
    val subioNivel=homeViewModel.subioNivel.collectAsState()

    if (usuarioState.value == null) {
        Text("Cargando usuario...")
        return }
    var selectedIndex by remember { mutableStateOf(0) }
    val items = listOf(
        BottomNavItem("Home", R.drawable.home),
        BottomNavItem("Diario", R.drawable.agenda),
        BottomNavItem("Articulos", R.drawable.articulos),
        BottomNavItem("Ejercicios", R.drawable.ejercicios),
        BottomNavItem("Camara", R.drawable.cam),
        BottomNavItem("Perfil", R.drawable.user)
    )
    val coroutineScope = rememberCoroutineScope()
    val TitleFont = FontFamily(Font(R.font.hollyberrypop))
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
    ) { innerPadding -> ContentHomeView(innerPadding, homeViewModel)

        if(mostrarDialogo == true){
            DialogoInformativo(
                titulo = "Advertencia",
                mensaje = "Funcionalidad prevista en futuras versiones",
                onCerrar = { mostrarDialogo = false }
            )
        }
        if (subioNivel.value){
            LevelUpDialog( onDismiss = {
                homeViewModel.resetSubioNivel()
            }
            )
        }
    }
}

//================ Contenido de la ventana home =================
@Composable
fun ContentHomeView(
    innerPadding: PaddingValues,
    homeViewModel: HomeViewModel
) {
    var showMoodDialog by remember { mutableStateOf(true) }
    var showTareasDiarias by remember { mutableStateOf(false) }
    LazyColumn(
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
        item{
            BotonHomeView("Acciones diarias","⭐", onClick = {showTareasDiarias=true})
        }
    }

    // Diálogo de Mood diario
    if (showMoodDialog) {
        AlertDialog(
            onDismissRequest = { showMoodDialog = false },
            title = { Text("¿Cómo te sientes hoy?") },
            text = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Elige tu estado de ánimo")
                    Spacer(Modifier.height(16.dp))

                    FlowRow(
                        maxLines = 2,
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
                        MoodButton("\uD83D\uDE30", "Estresado") { mood ->
                            homeViewModel.setMood(mood)
                            showMoodDialog = false
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
    if(showTareasDiarias){
        AccionesDiariasDialog(onDismiss = {showTareasDiarias=false},
            onConfirm ={ totalXp -> homeViewModel.sumarExp(totalXp);
         showTareasDiarias = false }
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


@Composable
fun BotonHomeView(
    text:String,
    icono:String,
    onClick: () -> Unit
){
    ElevatedButton(onClick=onClick,
        modifier=Modifier.fillMaxWidth()
            .padding(horizontal = 24.dp)
            .height(80.dp),
        shape= RoundedCornerShape(20.dp),
        colors= ButtonDefaults.buttonColors(
            containerColor=Color(0xFF60F5D8),
            contentColor=Color(0xFFF56D5F)
        )
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Text(icono, fontSize = 32.sp)
            Spacer(Modifier.width(12.dp))
            Text(text, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun AccionesDiariasDialog(
    onDismiss:()->Unit,
    onConfirm:(Double)->Unit
){
    val accionesDiarias=listOf(
        "Darme una ducha" to 10.0,
        "Pasear por la naturaleza" to 30.0,
        "Meditar al menos 10 minutos" to 20.0,
        "Escribir una lista de al menos 1 cosa positiva del día" to 25.0,
        "Leer durante 30 minutos" to 15.0
    )
    var accionCheckeada by remember{mutableStateOf(accionesDiarias.map { false })}

        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text("Acciones diarias") },
            text = {
                Column {
                    accionesDiarias.forEachIndexed { index, (title, xp) ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Checkbox(
                                checked = accionCheckeada[index],
                                onCheckedChange = { checked ->
                                    accionCheckeada = accionCheckeada.toMutableList().also {
                                        it[index] = checked
                                    }
                                }
                            )
                            Text("$title (+$xp XP)")
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    // Sumar XP de los elementos marcados
                    val totalXp = accionesDiarias.indices
                        .filter { accionCheckeada[it] }
                        .sumOf { accionesDiarias[it].second }

                    onConfirm(totalXp)
                }) {
                    Text("Confirmar")
                }
            },
            dismissButton = {
                TextButton(onClick = onDismiss) {
                    Text("Cancelar")
                }
            }
        )
}
@Composable
fun LevelUpDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("¡Buen trabajo!")
            }
        },
        title = { Text("¡Has subido de nivel!") },
        text = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                val composition by rememberLottieComposition(
                    LottieCompositionSpec.Asset("level_up.json")
                )
                val progress by animateLottieCompositionAsState( composition = composition,
                    iterations = 1
                )
                LaunchedEffect(progress) {
                    if (progress == 1f) {
                        onDismiss()
                    }
                }
                Box(
                    modifier = Modifier.fillMaxWidth()
                        .size(200.dp)
                ) {
                    LottieAnimation(
                        composition,
                        progress = progress
                    )
                }
            }
        }
    )
}

