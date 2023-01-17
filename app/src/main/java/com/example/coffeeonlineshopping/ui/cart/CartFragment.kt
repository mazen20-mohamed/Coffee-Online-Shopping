package com.example.coffeeonlineshopping.ui.cart

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeonlineshopping.R
import com.example.coffeeonlineshopping.databinding.FragmentCartBinding
import com.example.coffeeonlineshopping.model.Product
import com.example.coffeeonlineshopping.ui.menu.CartAdapter
import com.example.coffeeonlineshopping.ui.menu.MenuAdapter
import com.example.coffeeonlineshopping.ui.menu.list
import com.example.coffeeonlineshopping.ui.menu.totalP
import com.maximeroussy.invitrode.WordGenerator

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!
    lateinit var adapter:CartAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val total = root.findViewById<Button>(R.id.total)
        val layoutManager = LinearLayoutManager(activity)
        val menu =randomMenu()
        adapter = CartAdapter(menu)
        val rvMenu: RecyclerView = root.findViewById(R.id.rv_cart)
        rvMenu.layoutManager = layoutManager
        rvMenu.adapter = adapter
        adapter.products = list.toList()
        adapter.notifyDataSetChanged()
//        total.text = totalP.toString()
        return root
    }
    private fun randomMenu():List<Product>{
            val generator = WordGenerator()
            return List(200) {
                Product(
                    null,
                    generator.newWord(10),
                    0.0,
                    "https://picsum.photos/64/64",
                    0.0,
                    0.0,
                    generator.newWord(10),
                    generator.newWord(10),
                    0,
                    generator.newWord(10)
                )
            }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}