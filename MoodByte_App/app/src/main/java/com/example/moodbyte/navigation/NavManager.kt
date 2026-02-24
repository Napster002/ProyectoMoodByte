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
import com.example.moodbyte.ui.screens.DiarioView
import com.example.moodbyte.ui.screens.EntryReadOnlyView
import com.example.moodbyte.ui.screens.EntryView
import com.example.moodbyte.ui.screens.EjercicioView
import com.example.moodbyte.ui.screens.HomeView
import com.example.moodbyte.ui.screens.LoginView
import com.example.moodbyte.ui.screens.PerfilView
import com.example.moodbyte.ui.viewmodel.ArticulosViewModel
import com.example.moodbyte.ui.viewmodel.HomeViewModel
import com.example.moodbyte.ui.viewmodel.LoginViewModel
import com.example.moodbyte.ui.viewmodel.PerfilViewModel
import com.example.moodbyte.ui.screens.IAView
import com.example.moodbyte.ui.viewmodel.DiarioViewModel
import com.example.moodbyte.ui.viewmodel.EjercicioViewModel
import com.example.moodbyte.ui.viewmodel.EmocionViewModel
import com.example.moodbyte.ui.viewmodel.UsuarioViewModel
import org.koin.androidx.compose.koinViewModel
import java.time.LocalDate

@Composable
fun NavManager() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
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
            PerfilView(navController, perfilViewModel)
        }

        // Detalle de usuario
        composable(
            route = "detalle/{id}",
            arguments = listOf(navArgument("id") { type = NavType.LongType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getLong("id") ?: 0L
            //UsuarioDetailScreen(navController, id, usuarioViewModel)
        }
        composable("Camara"){
            IAView(navController)
        }

        composable("Diario"){
            val diarioViewModel: DiarioViewModel=koinViewModel()
            DiarioView(navController, diarioViewModel)
        }
        composable("diarioDetalle/{date}") { backStackEntry ->
            val date = LocalDate.parse(backStackEntry.arguments?.getString("date"))
            val diarioViewModel: DiarioViewModel=koinViewModel()
            EntryReadOnlyView(date, diarioViewModel, navController)
        }
        composable("diarioEditar/{date}") { backStackEntry ->
            val date = LocalDate.parse(backStackEntry.arguments?.getString("date"))
            val diarioViewModel: DiarioViewModel=koinViewModel()
            EntryView(date, diarioViewModel, navController)
        composable("Ejercicio"){
            val ejercicioViewModel: EjercicioViewModel =koinViewModel()
            val emocionViewModel: EmocionViewModel =koinViewModel()
            EjercicioView(navController, ejercicioViewModel,emocionViewModel)
        }
    }
}