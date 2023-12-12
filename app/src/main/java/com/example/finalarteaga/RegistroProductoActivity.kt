package com.example.finalarteaga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.LifecycleOwner
import com.example.finalarteaga.database.ProductoEntity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class RegistroProductoActivity : AppCompatActivity() {

    private lateinit var viewModel: ProductoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_producto)


        val etDescripcion: EditText = findViewById(R.id.etDescripProducto)
        val etCantidad: EditText = findViewById(R.id.etCantidadProducto)
        val etPrecio: EditText = findViewById(R.id.etPrecioProducto)
        val btnSave:Button=findViewById(R.id.btnSave)

        viewModel = ViewModelProvider(this).get(ProductoViewModel::class.java)

        btnSave.setOnClickListener {
            val productoEntity =
                ProductoEntity(etDescripcion.text.toString()
                    , etCantidad.text.toString()
                    , etPrecio.text.toString())
            viewModel.saveProduct(productoEntity)
            addObserver()
        }

    }

    private fun addObserver(){
        val observer  =  Observer<List<ProductoEntity>>{products->
            if(products!=null){
                var text="";
                for(product in products){
                    text += "ID:${product.productoId} Descrip:${product.descripcion} Precio: ${product.precio} |"
                    Log.i("ROOMDATABASE","Producto--> " + text)
                }
            }
        }
        viewModel.products.observe( this, observer)
    }
}