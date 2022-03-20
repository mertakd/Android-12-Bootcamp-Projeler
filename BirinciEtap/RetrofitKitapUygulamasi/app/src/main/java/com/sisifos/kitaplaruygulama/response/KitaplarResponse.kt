package com.sisifos.kitaplaruygulama.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sisifos.kitaplaruygulama.model.Kitap

data class KitaplarResponse (
    @SerializedName("books")
    @Expose var books: List<Kitap>,

    @SerializedName("success")
    @Expose var success : Int)