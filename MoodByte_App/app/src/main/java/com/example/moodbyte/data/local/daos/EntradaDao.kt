package com.example.moodbyte.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moodbyte.data.local.entities.EjercicioEntity
import com.example.moodbyte.data.local.entities.EntradaEntity
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@Dao
interface EntradaDao {

    @Query("SELECT * FROM entradas")
    fun getAllFlow(): Flow<List<EntradaEntity>>

    @Query("SELECT * FROM entradas WHERE id = :idEntrada")
    suspend fun getById(idEntrada: Long): EntradaEntity?

    @Query("SELECT * FROM entradas WHERE fechaEntrada = :fecha")
    suspend fun getByDate(fecha: LocalDate): EntradaEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entrada: EntradaEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entradas: List<EntradaEntity>)
}