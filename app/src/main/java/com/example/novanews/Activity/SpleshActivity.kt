package com.example.novanews.Activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.novanews.Helper.AuthHelper.Companion.authHelper
import com.example.novanews.R
import com.example.novanews.databinding.ActivitySpleshBinding

class SpleshActivity : AppCompatActivity() {

    lateinit var spleshBinding: ActivitySpleshBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        spleshBinding = ActivitySpleshBinding.inflate(layoutInflater)
        setContentView(spleshBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Handler().postDelayed({

            var intent:Intent

            if (authHelper.auth.currentUser == null){
                intent = Intent(this, LoginActivity::class.java)
            }else{
                intent = Intent(this, MainActivity::class.java)
            }
            startActivity(intent)
            finish()
            }, 3000)

        }
    }