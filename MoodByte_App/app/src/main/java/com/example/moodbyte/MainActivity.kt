package com.example.moodbyte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.moodbyte.data.local.AppDatabase
import com.example.moodbyte.data.remote.RetrofitClient
import com.example.moodbyte.data.repository.UsuarioRepository
import com.example.moodbyte.navigation.NavManager
import com.example.moodbyte.ui.screens.UsuarioView
import com.example.moodbyte.ui.theme.MoodByteTheme
import com.example.moodbyte.ui.viewmodel.LoginViewModel
import com.example.moodbyte.ui.viewmodel.UsuarioViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var isDarkTheme by remember { mutableStateOf(false) }
            MoodByteTheme(darkTheme = isDarkTheme) {
                NavManager(
                    onToggleTheme = { isDarkTheme = !isDarkTheme }
                )
            }
        }
    }
}