package com.example.moodbyte.navigation

import androidx.activity.result.contract.ActivityResultContracts
import com.example.moodbyte.ui.screens.UsuarioView
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.moodbyte.ui.screens.ArticulosView
import com.example.moodbyte.ui.screens.HomeView
import com.example.moodbyte.ui.screens.LoginView
import com.example.moodbyte.ui.screens.PerfilView
import com.example.moodbyte.ui.viewmodel.ArticulosViewModel
import com.example.moodbyte.ui.viewmodel.HomeViewModel
import com.example.moodbyte.ui.viewmodel.LoginViewModel
import com.example.moodbyte.ui.viewmodel.PerfilViewModel
import com.example.moodbyte.ui.screens.IAView
import com.example.moodbyte.ui.viewmodel.UsuarioViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavManager(onToggleTheme: () -> Unit) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "camara"
    ) {
        composable ("login"){
            val loginViewModel: LoginViewModel = koinViewModel()
            LoginView(navController, loginViewModel)
        }
        composable ("Inicio"){
            val homeViewModel: HomeViewModel = koinViewModel()
            HomeView(navController,homeViewModel)
        }
        // Borrar
        composable("usuarios") {
            val usuarioViewModel: UsuarioViewModel = koinViewModel()
            UsuarioView(navController,usuarioViewModel)
        }
        composable("Articulos"){
            val articulosViewModel: ArticulosViewModel=koinViewModel()
            ArticulosView(navController,articulosViewModel)
        }
        composable("Perfil"){
            val perfilViewModel: PerfilViewModel=koinViewModel()
            PerfilView(navController, perfilViewModel,onToggleTheme)
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
            IAView(navController)
        }
    }
}