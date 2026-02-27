package com.example.moodbyte.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moodbyte.data.local.entities.DiarioEntity
import com.example.moodbyte.data.local.entities.EjercicioEntity

@Dao
interface EjercicioDao {

    @Query("SELECT * FROM ejercicios")
    suspend fun getAll(): List<EjercicioEntity>

    @Query("SELECT * FROM ejercicios WHERE id= :idEjercicio")
    suspend fun getById(idEjercicio: Long): EjercicioEntity?
    @Query("DELETE FROM ejercicios")
    suspend fun clearAll()

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
}