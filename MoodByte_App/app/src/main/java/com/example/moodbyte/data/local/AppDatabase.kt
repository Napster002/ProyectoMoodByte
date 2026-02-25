package com.example.moodbyte.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.moodbyte.components.TypeConverter
import com.example.moodbyte.data.local.daos.ArticuloDao
import com.example.moodbyte.data.local.daos.DiarioDao
import com.example.moodbyte.data.local.daos.EjercicioDao
import com.example.moodbyte.data.local.daos.EntradaDao
import com.example.moodbyte.data.local.daos.EstadoDao
import com.example.moodbyte.data.local.daos.FraseDao
import com.example.moodbyte.data.local.daos.RegistroDao
import com.example.moodbyte.data.local.daos.UsuarioDao
import com.example.moodbyte.data.local.entities.UsuarioEntity
import com.example.moodbyte.data.local.entities.ArticuloEntity
import com.example.moodbyte.data.local.entities.EntradaEntity
import com.example.moodbyte.data.local.entities.DiarioEntity
import com.example.moodbyte.data.local.entities.EjercicioEntity
import com.example.moodbyte.data.local.entities.RegistroEntity
import com.example.moodbyte.data.local.entities.EstadoEntity
import com.example.moodbyte.data.local.entities.FraseEntity

@Database(
    entities = [
        UsuarioEntity::class,
        ArticuloEntity::class,
        DiarioEntity::class,
        EjercicioEntity::class,
        EntradaEntity::class,
        EstadoEntity::class,
        FraseEntity::class,
        RegistroEntity::class],
    version = 3 ,
    exportSchema = false
)
@TypeConverters(TypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
    abstract fun articuloDao(): ArticuloDao
    abstract fun diarioDao(): DiarioDao
    abstract fun ejercicioDao(): EjercicioDao
    abstract fun entradaDao(): EntradaDao
    abstract fun estadoDao(): EstadoDao
    abstract fun fraseDao(): FraseDao
    abstract fun registroDao(): RegistroDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "moodbyte_db"
                ).fallbackToDestructiveMigration()
                    .fallbackToDestructiveMigrationOnDowngrade()
                    .build().also { INSTANCE = it }
            }
    }
}