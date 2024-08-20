package com.example.novanews.Activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.novanews.R
import com.example.novanews.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var loginBinding: ActivityLoginBinding

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(loginBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val name = sharedPreferences.getString("name", "")
        val mail = sharedPreferences.getString("mail", "")
        val password = sharedPreferences.getString("password", "")
        loginBinding.edtMail.setText(mail)
        loginBinding.edtPassword.setText(password)
        loginBinding.edtMail.setText(name)

        loginBinding.btnLogin.setOnClickListener {
            val intent = Intent(this, CitySearchActivity::class.java)
            startActivity(intent)
        }


        loginBinding.txtRegister.setOnClickListener {
            val intent = Intent(this, SingupActivity::class.java)
            startActivity(intent)
        }
    }
}