package com.example.moodbyte.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.example.moodbyte.R
import com.example.moodbyte.components.BottomNavItem
import com.example.moodbyte.components.ContentDiarioView
import com.example.moodbyte.ui.viewmodel.DiarioViewModel
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DiarioView(navController: NavController, diarioViewModel: DiarioViewModel){
    var mostrarDialogo by remember { mutableStateOf(false) }
    val usuarioState=diarioViewModel.usuario.collectAsState()
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
        floatingActionButton =
            {
                FloatingActionButton(
                    onClick = {
                        val today = LocalDate.now()
                        navController.navigate("diarioEditar/$today")
                    },
                    containerColor = Color(0xFFFC908B)
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Añadir entrada")
                }
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
    ) { innerPadding -> ContentDiarioView(innerPadding, navController, diarioViewModel)
    }
}