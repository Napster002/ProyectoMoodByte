package com.example.moodbyte.di

import com.example.moodbyte.data.local.AppDatabase
import com.example.moodbyte.data.repository.UsuarioRepository
import com.example.moodbyte.data.remote.RetrofitClient
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
}