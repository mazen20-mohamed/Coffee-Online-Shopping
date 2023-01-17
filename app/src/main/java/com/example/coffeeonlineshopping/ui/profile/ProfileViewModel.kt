package com.example.coffeeonlineshopping.ui.profile

import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coffeeonlineshopping.model.User
import com.example.coffeeonlineshopping.network.retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileViewModel : ViewModel() {

    var _text = MutableLiveData<String>()
    var _email = MutableLiveData<String>()

    val text: LiveData<String> = _text
    val email:LiveData<String> = _email

}