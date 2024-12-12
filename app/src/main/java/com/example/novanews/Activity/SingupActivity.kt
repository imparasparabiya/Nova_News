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
import com.example.novanews.databinding.ActivitySingupBinding

class SingupActivity : AppCompatActivity() {

    lateinit var singupBinding: ActivitySingupBinding

//    val SHARED_PREFS: String = "MySharedPref"

//    val sharedPreferences: SharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        singupBinding = ActivitySingupBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(singupBinding.root)

        singupBinding.btnLogin.setOnClickListener {
            finish()
        }

        singupBinding.btnSingup.setOnClickListener {
           singUp()
        }
    }

    private  fun singUp(){
        val email = singupBinding.edtEmail.text.toString()
        val password = singupBinding.edtPassword.text.toString()

        authHelper.singUp(email, password)
        finish()
    }

//    private fun singUp() {
//        val name = singupBinding.edtName.text.toString()
//        val mail = singupBinding.edtEmail.text.toString()
//        val password = singupBinding.edtPassword.text.toString()
//
//        if (name.isEmpty() && mail.isEmpty() && password.isEmpty()){
//            val editor: SharedPreferences.Editor = sharedPreferences.edit()
//            editor.putString("name", name)
//            editor.putString("mail", mail)
//            editor.putString("password", password)
//            editor.apply()
//
//            Toast.makeText(this, "Singup Successfully", Toast.LENGTH_SHORT).show()
//
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//
//        }
//    }
}