package com.example.coffeeonlineshopping.signup

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.coffeeonlineshopping.R
import com.example.coffeeonlineshopping.model.User
import com.example.coffeeonlineshopping.model.UserData
import com.example.coffeeonlineshopping.network.retrofit
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val regis = findViewById<Button>(R.id.singup_btn_singup)
        regis.setOnClickListener {
            register()
        }
    }
    private fun register()
    {
        val name = findViewById<TextInputEditText>(R.id.name_register)
        val email = findViewById<TextInputEditText>(R.id.email_register)
        val password = findViewById<TextInputEditText>(R.id.password)
        var user = UserData(0,name.text.toString(),email.text.toString(), password.text.toString())
        retrofit.register(user)?.enqueue(object :Callback<User?>{
            override fun onResponse(call: Call<User?>, response: Response<User?>) {
                if (response.isSuccessful) {
                    Toast.makeText(
                        applicationContext,
                        response.body()?.name + " has registered",
                        Toast.LENGTH_LONG
                    ).show()
                    finish()
                } else {
                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<User?>, t: Throwable) {
                Toast.makeText(applicationContext,"Error with register!", Toast.LENGTH_LONG).show()
            }
        })
    }
}