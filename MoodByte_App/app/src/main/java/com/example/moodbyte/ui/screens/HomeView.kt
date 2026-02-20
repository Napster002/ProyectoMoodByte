package com.example.moodbyte.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.moodbyte.components.BottomNavItem
import com.example.moodbyte.components.ContentHomeView
import com.example.moodbyte.components.DialogoInformativo
import com.example.moodbyte.ui.viewmodel.UsuarioViewModel
import kotlinx.coroutines.launch
import com.example.moodbyte.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navController: NavController, usuarioViewModel: UsuarioViewModel){
    var mostrarDialogo by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }
    val items = listOf(
        BottomNavItem("Inicio", R.drawable.home),
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
                        icon = { item.icon },
                        label = { Text(item.label) },
                        selected = selectedIndex == index,
                        onClick = { mostrarDialogo = true}
                    )
                }
            }
        }
    ) { innerPadding -> ContentHomeView(innerPadding, navController, usuarioViewModel)

        if(mostrarDialogo == true){
            DialogoInformativo(
                titulo = "Advertencia",
                mensaje = "Funcionalidad prevista en futuras versiones",
                onCerrar = { mostrarDialogo = false }
            )
        }
    }
}