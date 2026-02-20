package com.example.moodbyte.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moodbyte.data.local.entities.EjercicioEntity
import com.example.moodbyte.data.local.entities.EstadoEntity

@Dao
interface EstadoDao {

    @Query("SELECT * FROM estados")
    suspend fun getAll():List<EstadoEntity>

    @Query("SELECT * FROM estados WHERE id= :idEstado")
    suspend fun getById(idEstado:Long):EstadoEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(estado:EstadoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(estados:List<EstadoEntity>)
}