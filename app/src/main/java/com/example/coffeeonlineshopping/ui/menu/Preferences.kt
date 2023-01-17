package com.example.coffeeonlineshopping.ui.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.coffeeonlineshopping.R
import com.example.coffeeonlineshopping.model.Product

var list =mutableListOf<Product>()
class Preferences : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perferences)
        val text = findViewById<TextView>(R.id.text)
        text.text = product?.name
        val imagee = findViewById<ImageView>(R.id.imagePre)
        Glide.with(this)
            .load(product?.image)
            .into(imagee)
        val price = findViewById<TextView>(R.id.price)
        price.text = product?.price.toString()+" EGP"

        val btn_plus = findViewById<Button>(R.id.plus)
        btn_plus.setOnClickListener {
            val number = findViewById<TextView>(R.id.number)
            number.text = (number.text.toString().toInt()+1).toString()
        }
        val btn_minus = findViewById<Button>(R.id.minus)
        btn_minus.setOnClickListener {
            val number = findViewById<TextView>(R.id.number)
            number.text = (number.text.toString().toInt()-1).toString()
        }
        var size = 1.0
        val image = findViewById<ImageView>(R.id.cup1)
        image.setOnClickListener{
            size=1.0
        }
        val image1 = findViewById<ImageView>(R.id.cup2)
        image1.setOnClickListener{
            size=2.0
        }
        val image2 = findViewById<ImageView>(R.id.cup3)
        image2.setOnClickListener{
            size=3.0
        }
        var sugar = 0.0
        val sugar2 = findViewById<ImageView>(R.id.sugar1)
        sugar2.setOnClickListener{
            sugar+=1.0
        }
        val sugar1 = findViewById<ImageView>(R.id.sugar2)
        sugar1.setOnClickListener{
            sugar+=2.0
        }
        val sugar3 = findViewById<ImageView>(R.id.sugar3)
        sugar3.setOnClickListener{
            sugar+=3.0
        }
         val add = findViewById<Button>(R.id.addcart)
        add.setOnClickListener {
            val number =findViewById<TextView>(R.id.number).text.toString().toInt()
            var pr = Product(0,product?.name,product?.price,product?.image,size,sugar,product?.description,
                product?.color,number, product?.category)
            list.add(pr)
            finish()
        }
    }
}