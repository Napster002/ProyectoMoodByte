package com.example.moodbyte.di

import com.example.moodbyte.data.local.AppDatabase
import com.example.moodbyte.data.repository.UsuarioRepository
import com.example.moodbyte.data.remote.RetrofitClient
import com.example.moodbyte.data.repository.ArticuloRepository
import com.example.moodbyte.data.repository.EntradaRepository
import com.example.moodbyte.data.repository.RegistroRepository
import com.example.moodbyte.ui.viewmodel.ArticulosViewModel
import com.example.moodbyte.ui.viewmodel.DiarioViewModel
import com.example.moodbyte.data.repository.EjercicioRepository
import com.example.moodbyte.data.repository.EstadoRepository
import com.example.moodbyte.ui.viewmodel.EjercicioViewModel
import com.example.moodbyte.ui.viewmodel.EstadoViewModel
import com.example.moodbyte.ui.viewmodel.HomeViewModel
import com.example.moodbyte.ui.viewmodel.LoginViewModel
import com.example.moodbyte.ui.viewmodel.PerfilViewModel
import com.example.moodbyte.ui.viewmodel.UsuarioSesionViewModel
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
    single {get<AppDatabase>().entradaDao()}
    single {get<AppDatabase>().ejercicioDao()}
    single {get<AppDatabase>().estadoDao()}

    // Repository
    single { UsuarioRepository(get(), get()) }
    single { RegistroRepository(get(), get()) }
    single { ArticuloRepository(get(),get()) }
    single { EntradaRepository(get(),get()) }
    single { EjercicioRepository(get(),get()) }
    single { EstadoRepository(get(),get()) }

    // ViewModel
    single { UsuarioSesionViewModel() }
    viewModel { LoginViewModel(get(), get(), get()) }
    viewModel { HomeViewModel(get(), get(),get())}
    viewModel{ ArticulosViewModel(get()) }
    viewModel{ PerfilViewModel(get(),get(),get()) }
    viewModel{ DiarioViewModel(get(),get()) }
    viewModel{ EjercicioViewModel(get()) }
    viewModel{ EstadoViewModel(get()) }
}
