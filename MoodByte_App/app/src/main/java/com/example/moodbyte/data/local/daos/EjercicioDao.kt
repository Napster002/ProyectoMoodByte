package com.example.moodbyte.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moodbyte.data.local.entities.DiarioEntity
import com.example.moodbyte.data.local.entities.EjercicioEntity
import com.example.moodbyte.data.local.entities.EntradaEntity
import com.example.moodbyte.domain.model.Ejercicio
import kotlinx.coroutines.flow.Flow

@Dao
interface EjercicioDao {

    @Query("SELECT * FROM ejercicios")
    fun getAll(): Flow<List<EjercicioEntity>>


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
       WHERE estadoid = :idEstado 
   """
    )
    fun getByNombreEstado(idEstado: Long): Flow<List<EjercicioEntity>>
}