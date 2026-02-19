package com.example.moodbyte.domain.model

import java.time.LocalDate

data class Entrada(
    val id:Long,
    val texto:String,
    val fechaEntrada: LocalDate
    )
