package com.example.moodbyte.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDao {

    @Query("SELECT * FROM usuarios")
    suspend fun getAll(): List<UsuarioEntity>

    @Query("SELECT * FROM usuarios WHERE id = :id")
    suspend fun getById(id: Long): UsuarioEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(usuario: UsuarioEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(usuarios: List<UsuarioEntity>)
}
