package com.example.moodbyte.navigation

import androidx.activity.result.contract.ActivityResultContracts
import com.example.moodbyte.ui.screens.UsuarioView
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.moodbyte.ui.screens.HomeView
import com.example.moodbyte.ui.screens.IAView
import com.example.moodbyte.ui.viewmodel.UsuarioViewModel

@Composable
fun NavManager(usuarioViewModel: UsuarioViewModel) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Home"
    ) {

        // Lista de usuarios
        composable("usuarios") {
            UsuarioView(navController, usuarioViewModel)
        }

        // Ventana home
        composable("Home") {
            HomeView(navController, usuarioViewModel)
        }

        // Detalle de usuario
        composable(
            route = "detalle/{id}",
            arguments = listOf(navArgument("id") { type = NavType.LongType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getLong("id") ?: 0L
            //UsuarioDetailScreen(navController, id, usuarioViewModel)
        }
        composable("camara"){
            IAView()
        }
    }
}