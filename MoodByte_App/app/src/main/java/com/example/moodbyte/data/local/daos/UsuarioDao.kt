package com.example.moodbyte.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moodbyte.data.local.entities.UsuarioEntity

@Dao
interface UsuarioDao {

    @Query("SELECT * FROM usuarios")
    suspend fun getAll(): List<UsuarioEntity>

    @Query("SELECT * FROM usuarios WHERE id = :id")
    suspend fun getById(id: Long): UsuarioEntity?

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insert(usuario: UsuarioEntity)

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertAll(usuarios: List<UsuarioEntity>)
}