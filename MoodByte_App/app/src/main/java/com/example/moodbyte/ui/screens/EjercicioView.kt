package com.example.moodbyte.ui.screens

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.moodbyte.components.CrearEjercicioDialog
import com.example.moodbyte.components.EjercicioViewContent
import com.example.moodbyte.ui.viewmodel.EjercicioViewModel
import com.example.moodbyte.ui.viewmodel.EstadoViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjercicioView(navController:NavController,ejercicioViewModel: EjercicioViewModel,emocionViewModel: EstadoViewModel){
    val TitleFont= FontFamily(Font(R.font.hollyberrypop))
    var selectedIndex by remember { mutableStateOf(0) }
    var showDialog by remember { mutableStateOf(false) }
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
        floatingActionButton ={  FloatingActionButton(onClick = {showDialog = true},
            containerColor = Color(0xFFF88383),
            shape= RoundedCornerShape(16.dp),
            modifier=Modifier.size(48.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Agregar",
                tint = Color.Black
            )
        }},
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
        EjercicioViewContent(innerPadding,ejercicioViewModel,emocionViewModel)
        if (showDialog) {
            CrearEjercicioDialog(
                onDismiss = { showDialog = false },
                onGuardar = { titulo, descripcion, recursoUrl, duracion, estadoId ->
                    ejercicioViewModel.insertarEjercicio(
                        titulo, descripcion, recursoUrl, duracion, estadoId
                    )
                    showDialog = false
                },
                estadoViewModel = emocionViewModel
            )
        }
    }
}