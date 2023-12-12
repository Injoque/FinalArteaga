package com.example.finalarteaga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val auth = FirebaseAuth.getInstance()

        val txtEmail: EditText = findViewById(R.id.etEmail)
        val txtPassword: EditText = findViewById(R.id.etPass)
        val btnLogin: Button = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val correo = txtEmail.text.toString()
            val clave = txtPassword.text.toString()

            //CORREO= luis@gmail.com
            //password= movil2023
            auth.signInWithEmailAndPassword(correo,clave)
                .addOnCompleteListener(this){task->
                    if(task.isSuccessful){
                        Snackbar
                            .make(
                                findViewById(android.R.id.content)
                                ,"Inicio de sesión exitoso"
                                , Snackbar.LENGTH_LONG
                            ).show()
                        startActivity(Intent(this, RegistroProductoActivity::class.java))
                    }else {
                        Snackbar
                            .make(
                                findViewById(android.R.id.content)
                                ,"Credenciales inválidas"
                                , Snackbar.LENGTH_LONG
                            ).show()
                    }
                }
        }

    }
}