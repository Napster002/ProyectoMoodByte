package com.example.moodbyte.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    val existing = diarioViewModel.getEntradaFor(date)
    var text by remember { mutableStateOf(existing?.texto ?: "") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
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
            modifier = Modifier.weight(6f)
                .fillMaxWidth(),
            placeholder = { Text("Escribe tu entrada aquí...") }
        )
        Spacer(modifier = Modifier.height(6.dp))
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

@Composable
fun EntryReadOnlyView(
    date: LocalDate,
    diarioViewModel: DiarioViewModel,
    navController: NavController
) {
    val entrada = diarioViewModel.getEntradaFor(date)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
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

        Spacer(modifier = Modifier.height(16.dp))

        if (entrada != null) {
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