package com.example.moodbyte.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moodbyte.data.local.entities.ArticuloEntity
import com.example.moodbyte.data.local.entities.DiarioEntity

@Dao
interface DiarioDao {
    @Query("SELECT * FROM diarios")
    suspend fun getAll():List<DiarioEntity>

    @Query("SELECT * FROM articulos WHERE id= :idDiario")
    suspend fun getById(idDiario:Long):DiarioEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(diario:DiarioEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(diarios:List<DiarioEntity>)
}