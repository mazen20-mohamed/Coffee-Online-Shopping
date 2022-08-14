package com.example.coffeeonlineshopping

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {
    lateinit var tvSingUp:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(2000)
        val splashScreen = installSplashScreen()
        setContentView(R.layout.activity_main)

        tvSingUp = findViewById(R.id.login_tv_singup)

        tvSingUp.setOnClickListener{
            val intent =Intent(this,SingUpActivity::class.java)
            startActivity(intent)
        }

    }
}