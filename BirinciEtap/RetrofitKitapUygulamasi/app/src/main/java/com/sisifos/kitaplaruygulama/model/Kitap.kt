package com.sisifos.kitaplaruygulama.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Kitap(
    //serilizedName isimleri json verileriyle aynı olacak
    @SerializedName("book_id") @Expose var book_id: Int,
    @SerializedName("book_name") @Expose var book_name: String,
    @SerializedName("book_author") @Expose var book_auther: String,
    @SerializedName("book_publisher") @Expose var book_publisher: String,
    @SerializedName("book_price") @Expose var book_price: String,
    @SerializedName("book_image_url") @Expose var book_image_url: String,)
    : Serializable
