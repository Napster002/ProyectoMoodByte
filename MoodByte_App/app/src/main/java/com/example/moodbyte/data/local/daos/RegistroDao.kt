package com.example.moodbyte.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moodbyte.data.local.entities.FraseEntity
import com.example.moodbyte.data.local.entities.RegistroEntity

@Dao
interface RegistroDao {
    @Query("SELECT * FROM registros")
    suspend fun getAll():List<RegistroEntity>

    @Query("SELECT * FROM articulos WHERE id= :idRegistro")
    suspend fun getById(idRegistro:Long):RegistroEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(registro:RegistroEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(registro:List<RegistroEntity>)
}