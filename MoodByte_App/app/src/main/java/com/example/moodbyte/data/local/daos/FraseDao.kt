package com.example.moodbyte.data.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moodbyte.data.local.entities.EjercicioEntity
import com.example.moodbyte.data.local.entities.FraseEntity

@Dao
interface FraseDao {

    @Query("SELECT * FROM frases")
    suspend fun getAll():List<FraseEntity>

    @Query("SELECT * FROM frases WHERE id= :idFrase")
    suspend fun getById(idFrase:Long):FraseEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(frase:FraseEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(frases:List<FraseEntity>)
}