package com.example.moodbyte.ui.screens


import androidx.compose.foundation.layout.padding
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
import com.example.moodbyte.R
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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.moodbyte.ui.viewmodel.UsuarioViewModel



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(usuarioViewModel: UsuarioViewModel) {

    val navController = rememberNavController()

    var selectedIndex by remember { mutableStateOf(0) }
    val TitleFont = FontFamily(Font(R.font.hollyberrypop))
    val items = listOf(
        BottomNavItem("Home", R.drawable.home, "Home"),
        BottomNavItem("Diario", R.drawable.agenda, "diario"),
        BottomNavItem("Articulos", R.drawable.articulos, "articulos"),
        BottomNavItem("Ejercicios", R.drawable.ejercicios, "ejercicios"),
        BottomNavItem("Camara", R.drawable.cam, "camara"),
        BottomNavItem("Perfil", R.drawable.user, "perfil")
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
                })
        },

        bottomBar = {

            NavigationBar {

                items.forEachIndexed { index, item ->

                    NavigationBarItem(

                        icon = {
                            Icon(
                                painterResource(item.icon),
                                contentDescription = item.label
                            )
                        },

                        selected = selectedIndex == index,

                        onClick = {
                            selectedIndex = index
                            navController.navigate(item.route)
                        }
                    )
                }
            }
        }

    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = "Home",
            modifier = Modifier.padding(padding)
        ) {

            composable("Home") {
                HomeView(navController, usuarioViewModel)
            }

            composable("diario") {
               // DiarioView(navController)
            }

            composable("articulos") {
               // ArticulosView(navController)
            }

            composable("ejercicios") {
               // EjerciciosView(navController)
            }

            composable("camara") {
                IAView()
            }

            composable("perfil") {
              //  PerfilView(navController)
            }
            composable(
                route = "detalle/{id}",
                arguments = listOf(navArgument("id") { type = NavType.LongType })
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getLong("id") ?: 0L
                //UsuarioDetailScreen(navController, id, usuarioViewModel)
            }
        }
    }
}
data class BottomNavItem(
    val label: String,
    val icon: Int,
    val route: String
)