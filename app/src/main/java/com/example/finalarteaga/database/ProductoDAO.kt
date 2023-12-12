package com.example.finalarteaga.database
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
@Dao
interface ProductoDAO {
    @Insert
    fun insert(customerEntity: ProductoEntity)
    @Update

    fun update(customerEntity: ProductoEntity)
    @Delete
    fun delete(customerEntity: ProductoEntity)
    @Query("SELECT * FROM productos ORDER BY producto_id")
    fun getCustomerOrderByLastName(): LiveData<List<ProductoEntity>>

}