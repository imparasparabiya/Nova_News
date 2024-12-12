package com.example.novanews.Activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.novanews.Helper.AuthHelper.Companion.authHelper
import com.example.novanews.R
import com.example.novanews.databinding.ActivityLoginBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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

//        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
//        val name = sharedPreferences.getString("name", "")
//        val mail = sharedPreferences.getString("mail", "")
//        val password = sharedPreferences.getString("password", "")
//        loginBinding.edtMail.setText(mail)
//        loginBinding.edtPassword.setText(password)
//        loginBinding.edtMail.setText(name)

        loginBinding.btnLogin.setOnClickListener {
        val email = loginBinding.edtMail.text.toString()
        val password = loginBinding.edtPassword.text.toString()

            GlobalScope.launch {
                var msg = authHelper.logIn(email, password)
                if (msg == "Successfully") {
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Toast.makeText(this@LoginActivity, msg, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}