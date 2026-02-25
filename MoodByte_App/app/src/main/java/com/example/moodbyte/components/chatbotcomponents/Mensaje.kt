package com.example.moodbyte.components.chatbotcomponents

data class Mensaje(
    val texto: String,
    val url: String? = null,
    val esUsuario: Boolean = false
)