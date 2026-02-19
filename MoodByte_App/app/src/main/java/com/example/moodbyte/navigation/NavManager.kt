package com.example.moodbyte.navigation

import com.example.moodbyte.ui.screens.UsuarioView
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.moodbyte.ui.viewmodel.UsuarioViewModel

@Composable
fun NavManager(usuarioViewModel: UsuarioViewModel) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "usuarios"
    ) {

        // Lista de usuarios
        composable("usuarios") {
            UsuarioView(navController, usuarioViewModel)
        }

        // Detalle de usuario
        composable(
            route = "detalle/{id}",
            arguments = listOf(navArgument("id") { type = NavType.LongType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getLong("id") ?: 0L
            //UsuarioDetailScreen(navController, id, usuarioViewModel)
        }
    }
}