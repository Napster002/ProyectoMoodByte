package com.example.moodbyte.di

import com.example.moodbyte.data.local.AppDatabase
import com.example.moodbyte.data.repository.UsuarioRepository
import com.example.moodbyte.data.remote.RetrofitClient
<<<<<<< Updated upstream
=======
import com.example.moodbyte.data.repository.ArticuloRepository
import com.example.moodbyte.data.repository.RegistroRepository
import com.example.moodbyte.ui.viewmodel.ArticulosViewModel
import com.example.moodbyte.ui.viewmodel.EjercicioViewModel
import com.example.moodbyte.ui.viewmodel.HomeViewModel
import com.example.moodbyte.ui.viewmodel.LoginViewModel
import com.example.moodbyte.ui.viewmodel.PerfilViewModel
import com.example.moodbyte.ui.viewmodel.UsuarioSesionViewModel
>>>>>>> Stashed changes
import com.example.moodbyte.ui.viewmodel.UsuarioViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // Retrofit
    single { RetrofitClient.api }

    // Room Database
    single { AppDatabase.getDatabase(get()) }
    single { get<AppDatabase>().usuarioDao() }

    // Repository
    single { UsuarioRepository(get(), get()) }

    // ViewModel
    viewModel { UsuarioViewModel(get()) }
<<<<<<< Updated upstream
}
=======
    viewModel { LoginViewModel(get(), get(), get()) }
    viewModel { HomeViewModel(get(), get()) }
    viewModel{ ArticulosViewModel(get()) }
    viewModel{ PerfilViewModel(get()) }
    viewModel{ EjercicioViewModel(get()) }
}
>>>>>>> Stashed changes
