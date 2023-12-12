package com.example.finalarteaga.database
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
class ProductoRepository(application: Application) {
    private val productoDao:
            ProductoDAO? = ProductoDatabase
        .getInstance(application)?.customerDao()

    fun insert(productoEntity:ProductoEntity){
        if(productoDao!=null)
            InsertAsyncTask(productoDao).execute(productoEntity)
    }
    fun getProducts(): LiveData<List<ProductoEntity>>{
        return productoDao?.getCustomerOrderByLastName() ?: MutableLiveData<List<ProductoEntity>>().apply{
            value = emptyList()
        }
    }

    private class InsertAsyncTask
        (private val productoDao: ProductoDAO):AsyncTask<ProductoEntity, Void, Void>(){
        override fun doInBackground(vararg products: ProductoEntity?): Void? {
            for(product in products){
                if(product!=null)
                    productoDao.insert(product)
            }
            return null
        }
    }

}