package com.example.coffeeonlineshopping

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.coffeeonlineshopping.model.UserLogin
import com.example.coffeeonlineshopping.network.retrofit
import com.example.coffeeonlineshopping.signup.SignUpActivity
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
var token :String? = null
class MainActivity : AppCompatActivity() {
    lateinit var tvSingUp: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val splashScreen = installSplashScreen()
        val loginBtn = findViewById<Button>(R.id.login_btn_login)
        loginBtn.setOnClickListener {
            login()
        }
        tvSingUp = findViewById(R.id.login_tv_singup)
        tvSingUp.setOnClickListener{
            val intent =Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
    private fun login()
    {
        val email = findViewById<TextInputEditText>(R.id.email)
        val password = findViewById<TextInputEditText>(R.id.password)
        val userLogin = UserLogin(email.text.toString(),password.text.toString())
        retrofit.login(userLogin)
         ?.enqueue(object:Callback<String?> {
            override fun onResponse(call: Call<String?>, response: Response<String?>) {
                if(response.isSuccessful)
                {
                    token = "Bearer "
                    token+=response.body()
                    Toast.makeText(applicationContext,"Welcome Back", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this@MainActivity,StartActivity::class.java))
                }
                else{
                    Toast.makeText(applicationContext,"Error", Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<String?>, t: Throwable) {
                Toast.makeText(applicationContext,"Error with Login!", Toast.LENGTH_LONG).show()
            }
        })
    }
}
