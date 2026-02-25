package com.example.moodbyte.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.moodbyte.data.local.entities.DiarioEntity
import com.example.moodbyte.data.local.entities.EjercicioEntity
import com.example.moodbyte.domain.model.relaciones.EjercicioConEstado

@Dao
interface EjercicioDao {

    @Query("SELECT * FROM ejercicios")
    suspend fun getAll(): List<EjercicioEntity>

    @Query("SELECT * FROM ejercicios WHERE id= :idEjercicio")
    suspend fun getById(idEjercicio: Long): EjercicioEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ejercicio: EjercicioEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(ejercicios: List<EjercicioEntity>)

    @Query(
        """
        SELECT e.* 
        FROM ejercicios e
        INNER JOIN estados s ON e.estado_id = s.id
        WHERE s.nombre = :nombreEstado
    """
    )
    suspend fun getByNombreEstado(nombreEstado: String): List<EjercicioEntity>

    @Transaction
    @Query("SELECT * FROM estados")
    suspend fun getEstadosConEjercicios(): List<EjercicioConEstado>

    @Transaction
    @Query("SELECT * FROM ejercicios")
    suspend fun getEjerciciosConEstado(): List<EjercicioConEstado>

    @Transaction
    @Query("SELECT * FROM estados WHERE nombre = :nombreEstado")
    suspend fun getEstadoConEjerciciosPorNombre(nombreEstado: String): EjercicioConEstado?

}