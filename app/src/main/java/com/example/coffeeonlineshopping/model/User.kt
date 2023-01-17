package com.example.coffeeonlineshopping.model
import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("id") var id : Int? = null,
    @SerializedName("name") var name : String?  = null,
    @SerializedName("email") var email :String? = null,
)
data class UserLogin(var email: String?= "",var password:String?="")

data class UserData(    var id:Int? ,
                   var name:String?,
                   var email:String?,
                   var password:String?)
