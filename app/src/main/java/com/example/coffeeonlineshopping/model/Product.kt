package com.example.coffeeonlineshopping.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Url

data class Product (
    @SerializedName("id") var id : Int? = null,
    @SerializedName("name") var name : String?  = null,
    @SerializedName("price") var price :Double? =null,
    @SerializedName("image"  ) var image : String? = null,
    @SerializedName("size"  ) var size : Double? = null,
    @SerializedName("sugar"  ) var sugar : Double? = null,
    @SerializedName("description"  ) var description : String? = null,
    @SerializedName("color"  ) var color : String? = null,
    @SerializedName("boughtItemsCount"  ) var boughtItemsCount : Int? = null,
    @SerializedName("category"  ) var category : String? = null
)