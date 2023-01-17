package com.example.coffeeonlineshopping.ui.menu

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeonlineshopping.R
import com.example.coffeeonlineshopping.databinding.FragmentMenuBinding
import com.example.coffeeonlineshopping.model.Product
import com.example.coffeeonlineshopping.network.retrofit
import com.example.coffeeonlineshopping.token
import com.maximeroussy.invitrode.WordGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
var product:Product? = null
class MenuFragment : Fragment(),MenuAdapter.ItemClickListener{
    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!
    lateinit var adapter:MenuAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val layoutManager = LinearLayoutManager(activity)
        val menu =randomMenu()
        adapter = MenuAdapter(menu,this)

        val rvMenu: RecyclerView = root.findViewById(R.id.rv_coffee)
        rvMenu.layoutManager = layoutManager
        rvMenu.adapter = adapter
        requestMenu()

        return root
    }

    private fun randomMenu():List<Product> {
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
    private fun requestMenu(){
        retrofit.getProducts(token)
            ?.enqueue(object:Callback<List<Product>?>{
                override fun onResponse(
                    call: Call<List<Product>?>,
                    response: Response<List<Product>?>
                ) {
                    if(response.isSuccessful){
                        adapter.products = response.body()
                        adapter.notifyDataSetChanged()
                    }
                    else{
                        Toast.makeText(activity,token, Toast.LENGTH_LONG).show()
                    }
                }
                override fun onFailure(call: Call<List<Product>?>, t: Throwable) {
                    Toast.makeText(activity,t.localizedMessage, Toast.LENGTH_LONG).show()
                }
            })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun itemClick(position: Int) {
        product = adapter.products?.get(position)
        startActivity(Intent(context,Preferences::class.java))
    }
}