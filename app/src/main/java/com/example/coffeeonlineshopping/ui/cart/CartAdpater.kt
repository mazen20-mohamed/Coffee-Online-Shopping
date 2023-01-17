package com.example.coffeeonlineshopping.ui.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coffeeonlineshopping.R
import com.example.coffeeonlineshopping.model.Product
var totalP:Int = 0
class CartAdapter(var products: List<Product>): RecyclerView.Adapter<CartAdapter.CartViewHolder>(){
     class CartViewHolder(view: View) :RecyclerView.ViewHolder(view) {
        var typeCoffee: TextView
        var image: ImageView
        var totalPrice:TextView
        init
        {
            typeCoffee = view.findViewById(R.id.coffeeT)
            image = view.findViewById(R.id.coffeei)
            totalPrice=  view.findViewById(R.id.total)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_cart, parent, false)

        return CartViewHolder(view)
    }
    private fun getSize(size:Double?):String{
        if(size==1.0)
        {
            return "Small"
        }
        else if(size  ==2.0)
        {
            return "Medium"
        }
        else
            return "Large"
    }
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val product =products.get(position)
        holder.typeCoffee.text =product.boughtItemsCount.toString()+" X "+product.name
        Glide.with(holder.itemView)
            .load(product.image)
            .into(holder.image)
        holder.totalPrice.text = "Sugar: "+product.sugar.toString()+" , Size: "+getSize(product.size)
//        totalP+= (product.boughtItemsCount!!)
    }
    override fun getItemCount(): Int  = products.size
}