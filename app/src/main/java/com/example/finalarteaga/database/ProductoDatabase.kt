package com.example.finalarteaga.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities= [ProductoEntity::class], version = 1)

abstract class ProductoDatabase: RoomDatabase() {

    abstract fun customerDao(): ProductoDAO

    companion object {
        private const val DATABASE_NAME = "mantenimiento"
        @Volatile
        private var INSTANCE: ProductoDatabase?=null

        fun getInstance(context: Context): ProductoDatabase?{
            INSTANCE?: synchronized(this){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    ProductoDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return INSTANCE
        }
    }

}