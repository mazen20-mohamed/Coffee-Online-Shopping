package com.example.coffeeonlineshopping

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.coffeeonlineshopping.model.User
import com.example.coffeeonlineshopping.network.retrofit
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
        val updateText = findViewById<Button>(R.id.updateText)
        updateText.setOnClickListener {
            editProfile()
        }
    }
    fun editProfile()
    {
        val text = findViewById<TextInputEditText>(R.id.name_update)
        retrofit.editProfile(token,text.text.toString())
            ?.enqueue(object: Callback<User?> {
                override fun onResponse(call: Call<User?>, response: Response<User?>) {
                    Toast.makeText(this@EditProfile,"Updated", Toast.LENGTH_LONG).show()
                    finish()
                }
                override fun onFailure(call: Call<User?>, t: Throwable) {
                    Toast.makeText(this@EditProfile,"problem with server", Toast.LENGTH_LONG).show()
                }
            })
    }
}