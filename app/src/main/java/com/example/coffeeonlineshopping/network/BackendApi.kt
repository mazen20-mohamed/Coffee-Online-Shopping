package com.example.coffeeonlineshopping.network
import android.widget.ImageView
import com.example.coffeeonlineshopping.model.Product
import com.example.coffeeonlineshopping.model.User
import com.example.coffeeonlineshopping.model.UserData
import com.example.coffeeonlineshopping.model.UserLogin
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*

//https://coffeerest-skeleton.herokuapp.com/
//curl --location --request GET 'https://coffeerest-skeleton.herokuapp.com/product/v1/get/products
//--header 'Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdHJpbmciLCJleHAiOjE2NjA2NTY0MDN9.lwdZXkLZ6yw9dv8tjKx4n1zg2RCkHqXA-j_kQLWY-Z6zTEBY69KfUPaK10_NlnDJx1aneAHCJXZ71UrDvu4rkw'
interface BackendApi{

    @GET("product/v1/get/products")
    fun getProducts(@Header("Authorization") token: String?):Call<List<Product>>?

    @POST("user/v1/new")
    fun register(@Body user: UserData):Call<User>?

    @POST("user/v1/login")
    fun login(@Body user: UserLogin):Call<String>?

    @GET("user/v1/profile")
    fun getProfile(@Header("Authorization")token :String?):Call<User>?

    @PUT("user/v1/edit")
    fun editProfile(@Header("Authorization")token :String?,@Body userName: String):Call<User>?

}
val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
 val client = OkHttpClient.Builder().addInterceptor(logging).build()

var gson = GsonBuilder()
    .setLenient()
    .create()

var retrofit: BackendApi= Retrofit.Builder()
    .baseUrl("https://coffeerest-skeleton.herokuapp.com/")
    .addConverterFactory(GsonConverterFactory.create(gson))
    .addConverterFactory(ScalarsConverterFactory.create())
    .client(client)
    .build()
    .create(BackendApi::class.java)
