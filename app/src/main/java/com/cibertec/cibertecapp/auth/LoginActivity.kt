package com.cibertec.cibertecapp.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.cibertec.cibertecapp.R
import com.cibertec.cibertecapp.menu.MenuActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        val email = findViewById<EditText>(R.id.edtEmail)
        val password = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnLogin.setOnClickListener {
            val emailValue = email.text.toString()
            val passwordValue = password.text.toString()
            viewModel.verifyLogin(emailValue, passwordValue)
        }

        btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        observerLiveData()

    }

    private fun observerLiveData() {
        viewModel.userLoginStatus.observe(this) {
            if (it) {
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Verificar sus datos",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

}