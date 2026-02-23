package com.example.moodbyte.components.chatbotcomponents


import java.util.Calendar

fun obtenerSaludo(): String {

    val hora = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

    return when (hora) {

        in 6..11 -> "Buenos días"
        in 12..19 -> "Buenas tardes"
        else -> "Buenas noches"
    }
}