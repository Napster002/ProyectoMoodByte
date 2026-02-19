package com.example.moodbyte.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moodbyte.data.local.entities.ArticuloEntity

@Dao
interface ArticuloDao {
    @Query("SELECT * FROM articulos")
    suspend fun getAll():List<ArticuloEntity>

    @Query("SELECT * FROM articulos WHERE id= :idArticulo")
    suspend fun getById(idArticulo:Long):ArticuloEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(articulo:ArticuloEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(articulos:List<ArticuloEntity>)
}