package com.example.moodbyte.domain.model.relaciones

import androidx.room.Embedded
import androidx.room.Relation
import com.example.moodbyte.data.local.entities.EjercicioEntity
import com.example.moodbyte.data.local.entities.EstadoEntity

data class EjercicioConEstado(
    @Embedded val estado: EstadoEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "estado_id"
    )
    val ejercicios: List<EjercicioEntity>
)
