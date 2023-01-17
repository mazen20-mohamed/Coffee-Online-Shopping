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

class MenuAdapter(var products: List<Product>?,private val click:ItemClickListener): RecyclerView.Adapter<MenuAdapter.MenuViewHolder>(){
    inner class MenuViewHolder(view: View) :RecyclerView.ViewHolder(view),View.OnClickListener {
        var typeCoffee: TextView
        var image: ImageView
        init
        {
            typeCoffee = view.findViewById(R.id.coffeeType)
            image = view.findViewById(R.id.coffeeImage)
            view.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
            val v = adapterPosition
            if(v!=RecyclerView.NO_POSITION)
            {
                click.itemClick(v)
            }
        }
    }
    interface ItemClickListener {
        fun itemClick(position: Int)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }
    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val product =products?.get(position)
        holder.typeCoffee.text =product?.name
        Glide.with(holder.itemView)
            .load(product?.image)
            .into(holder.image)
    }
    override fun getItemCount(): Int  = products?.size ?: 0
}