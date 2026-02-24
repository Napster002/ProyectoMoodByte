package com.example.moodbyte.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.moodbyte.R
import com.example.moodbyte.components.CustomRoundedButton
import com.example.moodbyte.ui.viewmodel.DiarioViewModel
import java.time.LocalDate

@Composable
fun EntryView(
    date: LocalDate,
    diarioViewModel: DiarioViewModel,
    navController: NavController
) {
    val entradas by diarioViewModel.entradas.collectAsState()
    val existing = entradas.firstOrNull { it.fechaEntrada == date }
    var text by remember { mutableStateOf("") }

    LaunchedEffect(existing?.id) {
        text = existing?.texto ?: ""
    }

    Scaffold(
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                CustomRoundedButton(
                    "Guardar entrada",
                    R.drawable.agenda,
                    Color(0xFFFC908B),
                    onClick = {
                        diarioViewModel.saveEntrada(date, text)
                        navController.popBackStack()
                    }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Entrada del $date",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                placeholder = { Text("Escribe tu entrada aquí...") }
            )
        }
    }
}

@Composable
fun EntryReadOnlyView(
    date: LocalDate,
    diarioViewModel: DiarioViewModel,
    navController: NavController
) {
    val entradas by diarioViewModel.entradas.collectAsState()
    val entrada = entradas.firstOrNull { it.fechaEntrada == date }

    Scaffold(
        bottomBar = {
            if (entrada != null) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CustomRoundedButton(
                        "Editar entrada",
                        R.drawable.agenda,
                        Color(0xFFFC908B),
                        onClick = {
                            navController.navigate("diarioEditar/$date")
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Entrada del $date",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = entrada?.texto ?: "No hay entrada",
                fontSize = 18.sp
            )
        }
    }
}