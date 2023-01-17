package com.example.coffeeonlineshopping.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.coffeeonlineshopping.EditProfile
import com.example.coffeeonlineshopping.MainActivity
import com.example.coffeeonlineshopping.databinding.FragmentProfileBinding
import com.example.coffeeonlineshopping.model.User
import com.example.coffeeonlineshopping.network.retrofit
import com.example.coffeeonlineshopping.token
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    private val binding get() = _binding!!
    lateinit var userName:TextView
    lateinit var email:TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

          userName= binding.profileUserName
          email= binding.profileEmail
        getProfile()
        val btnLogout = binding.logout
        btnLogout.setOnClickListener {
            token = null
            activity?.finish()
        }
        val btnEditProfile = binding.editProfile
        btnEditProfile.setOnClickListener {
            startActivity(Intent(activity,EditProfile::class.java))
        }
        return root
    }
    fun getProfile(){
        retrofit.getProfile(token)
            ?.enqueue(object: Callback<User?> {
                override fun onResponse(call: Call<User?>, response: Response<User?>) {
                    userName.text = response.body()?.name
                    email.text = response.body()?.email
                }
                override fun onFailure(call: Call<User?>, t: Throwable) {
                    Toast.makeText(activity,t.message, Toast.LENGTH_LONG).show()
                }
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}