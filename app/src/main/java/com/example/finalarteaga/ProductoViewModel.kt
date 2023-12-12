package com.example.finalarteaga

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.finalarteaga.database.ProductoEntity
import com.example.finalarteaga.database.ProductoRepository

class ProductoViewModel(application: Application): AndroidViewModel(application) {

    private var repository = ProductoRepository(application)
    val products = repository.getProducts()

    fun saveProduct(productoEntity: ProductoEntity){
        repository.insert(productoEntity)
    }
}