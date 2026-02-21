package com.example.moodbyte.di

import com.example.moodbyte.data.local.AppDatabase
import com.example.moodbyte.data.repository.UsuarioRepository
import com.example.moodbyte.data.remote.RetrofitClient
import com.example.moodbyte.data.repository.ArticuloRepository
import com.example.moodbyte.data.repository.RegistroRepository
import com.example.moodbyte.ui.viewmodel.ArticulosViewModel
import com.example.moodbyte.ui.viewmodel.HomeViewModel
import com.example.moodbyte.ui.viewmodel.LoginViewModel
import com.example.moodbyte.ui.viewmodel.UsuarioSesionViewModel
import com.example.moodbyte.ui.viewmodel.UsuarioViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // Retrofit
    single { RetrofitClient.api }

    // Room Database
    single { AppDatabase.getDatabase(get()) }

    // DAOs
    single { get<AppDatabase>().usuarioDao() }
    single { get<AppDatabase>().registroDao() }
    single {get<AppDatabase>().articuloDao()}

    // Repository
    single { UsuarioRepository(get(), get()) }
    single { RegistroRepository(get(), get()) }
    single { ArticuloRepository(get(),get()) }

    // ViewModel
    single { UsuarioSesionViewModel() }
    viewModel { UsuarioViewModel(get()) }
    viewModel { LoginViewModel(get(), get(), get()) }
    viewModel { HomeViewModel(get(), get()) }
    viewModel{ ArticulosViewModel(get()) }
}
