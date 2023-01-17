package com.example.coffeeonlineshopping.ui.menu

import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenuViewModel : ViewModel() {

    val _text = MutableLiveData<String>().apply {
        value = "fragment"
    }
    val _image = MutableLiveData<ImageView>().apply {
        value = null
    }
    val textt: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    var text: LiveData<String> = _text
    var image: LiveData<ImageView> =_image

}