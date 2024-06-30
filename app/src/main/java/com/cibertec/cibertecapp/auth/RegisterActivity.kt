package com.cibertec.cibertecapp.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.cibertec.cibertecapp.R
import com.cibertec.cibertecapp.menu.MenuActivity
import com.google.android.material.textfield.TextInputEditText

class RegisterActivity: AppCompatActivity() {

    private lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]

        val edtName = findViewById<TextInputEditText>(R.id.edtName)
        val edtLastname = findViewById<TextInputEditText>(R.id.edtLastname)
        val edtEmail = findViewById<TextInputEditText>(R.id.edtEmail)
        val edtPassword = findViewById<TextInputEditText>(R.id.edtPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val name = edtName.text.toString()
            val lastname = edtLastname.text.toString()
            val email = edtEmail.text.toString()
            val pass = edtPassword.text.toString()
            viewModel.verifyRegister(name, lastname, email, pass)
        }

        observerLiveData()
    }

    private fun observerLiveData() {
        viewModel.userRegisterStatus.observe(this) {
            if (it) {
                Toast.makeText(this, "Registro correcto",
                    Toast.LENGTH_SHORT).show()
                // snackbar
                // alert
                finish()
            } else {
                Toast.makeText(this, "Verificar sus datos",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

}